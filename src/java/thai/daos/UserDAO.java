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
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import thai.dtos.UserObj;
import static thai.utils.Constant.LOGGER;
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

            String sql = "SELECT userID, password, userName, userPhone, userEmail, roleID, userStatus, userAddress\n"
                    + "FROM [dbo].[User]"
                    + "Where userID = ? AND password = ? AND userStatus = 'active'";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, username);
            PRE.setString(2, password);
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

    
}
