/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thai.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import thai.dtos.UserObj;
import static thai.utils.Constants.LOGGER;
import thai.utils.DBUtil;

/**
 *
 * @author ASUS
 */
public class UserDAO {

    private Connection CONN = null;
    private PreparedStatement PRE = null;
    private ResultSet RS = null;

    private void closeConnection() {
        try {
            if (RS != null) {
                RS.close();
            }
            if (PRE != null) {
                PRE.close();
            }
            if (CONN != null) {
                CONN.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.info("ERROR at UserDAO:" + e.getMessage());
        }
    }

    public UserObj checkLogin(String username, String password) throws Exception {

        UserObj dto = new UserObj();
        try {
            String passwordSQL = "";
            if (!password.equals("")) {
                passwordSQL = "and [password] = ?";
            }
            String sql = "SELECT userID, password, userName, userPhone, userEmail, roleID, userStatus, userAddress\n"
                    + "FROM [dbo].[User]"
                    + "Where userID = ? AND userStatus = 'active'" + passwordSQL;
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, username);
            if (!password.equals("")) {
                PRE.setString(2, password);
            }
            RS = PRE.executeQuery();
            if (RS.next()) {
                String fullname = RS.getString("userName");
                String userID = RS.getString("userID");
                String email = RS.getString("userEmail");
                String userStatus = RS.getString("userStatus");
                String role = RS.getString("roleId");
                String userPhone = RS.getString("userPhone");
                String userAddress = RS.getString("userAddress");
                dto = new UserObj(userID, password, fullname, userPhone, email, userAddress, role, userStatus, "");
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<UserObj> getAllUser() throws SQLException, NamingException {
        List<UserObj> result = new ArrayList<>();

        try {
            String sql = "SELECT userID, userName, userPhone, userEmail, userStatus, userAddress\n"
                    + "FROM [dbo].[User]\n"
                    + "Where roleID = 'US'";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            RS = PRE.executeQuery();
            while (RS.next()) {
                String userID = RS.getString("userID");
                String userName = RS.getString("userName");
                String userPhone = RS.getString("userPhone");
                String userEmail = RS.getString("userEmail");
                String userStatus = RS.getString("userStatus");
                String userAddress = RS.getString("userAddress");
                UserObj user = new UserObj(userID, "", userName, userPhone, userEmail, userAddress, "", userStatus, "");
                result.add(user);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insertAccount(UserObj dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO [dbo].[User] ( userID, [password], userName, userPhone,userEmail,[userAddress], userCreateDate, [userStatus], roleID )\n"
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, dto.getUserID());
            PRE.setString(2, dto.getUserPassword());
            PRE.setString(3, dto.getUserFullName());
            PRE.setString(4, dto.getUserPhone());
            PRE.setString(5, dto.getUserEmail());
            PRE.setString(6, dto.getUserAddress());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            Date parsedDate = dateFormat.parse(dto.getUserCreateDate());
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            PRE.setTimestamp(7, timestamp);
            PRE.setString(8, dto.getUserStatus());
            PRE.setString(9, dto.getUserRoleID());

            check = PRE.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateAccount(UserObj dto) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE [dbo].[User] set [userStatus] = ? "
                    + "Where [userID] = ?";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, dto.getUserStatus());
            PRE.setString(2, dto.getUserID());
            check = PRE.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

}
