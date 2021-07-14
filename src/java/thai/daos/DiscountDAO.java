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
import thai.dtos.DiscountObj;
import static thai.utils.Constant.LOGGER;
import thai.utils.DBUtil;

/**
 *
 * @author ASUS
 */
public class DiscountDAO {

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
            LOGGER.info("ERROR at DiscountDAO:" + e.getMessage());
        }
    }

    public DiscountObj getDiscountByUserId(String userId) throws SQLException, NamingException {
        DiscountObj dto = new DiscountObj();
        try {
            String sql = "SELECT [discountID], [discountName], [discountPercent], [discountStatus]\n"
                    + "FROM Discount\n"
                    + "WHERE [userID] = ? AND discountStatus = 'active'";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, userId);
            RS = PRE.executeQuery();

            if (RS.next()) {
                String discountID = RS.getString("discountID");
                String discountName = RS.getString("discountName");
                float discountPercent = RS.getFloat("discountPercent");
                String discountStatus = RS.getString("discountStatus");
                dto = new DiscountObj(discountID, discountName, discountPercent, discountStatus);
            }

        } finally {
            closeConnection();
        }
        return dto;
    }

    public DiscountObj getDiscountByDiscountID(String id, String userId) throws SQLException, NamingException {
        DiscountObj dto = new DiscountObj();
        try {
            String sql = "SELECT [discountID], [discountName], [discountPercent]\n"
                    + "FROM Discount\n"
                    + "WHERE [discountID] = ? AND [userID] = ? AND discountStatus = 'active'";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, id);
            PRE.setString(2, userId);
            RS = PRE.executeQuery();

            if (RS.next()) {
                String discountID = RS.getString("discountID");
                String discountName = RS.getString("discountName");
                float discountPercent = RS.getFloat("discountPercent");
                dto = new DiscountObj(discountID, discountName, discountPercent, "");
            }

        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public List<DiscountObj> getDiscountByUser(String userID) throws SQLException, NamingException {
        List<DiscountObj> result = new ArrayList<>();

        try {
            String sql = "SELECT [discountID], [discountName], [discountPercent]\n"
                    + "FROM [dbo].[Discount]\n"
                    + "WHERE userID = ?\n AND discountStatus = 'active'";

            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, userID);
            RS = PRE.executeQuery();
            while (RS.next()) {
                String discountID = RS.getString("discountID");
                String discountName = RS.getString("discountName");
                float discountPercent = RS.getFloat("discountPercent");
                DiscountObj dis = new DiscountObj(discountID, discountName, discountPercent, "");
                result.add(dis);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insertDiscount(DiscountObj dto, String userID) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO [dbo].[Discount] ([discountID], discountName, discountPercent, discountStatus, createDate, userID)\n"
                    + "VALUES (?,?,?,?,?,?)";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, dto.getDiscountID());
            PRE.setString(2, dto.getDiscountName());
            PRE.setFloat(3, dto.getDiscountPercent());
            PRE.setString(4, dto.getDiscountStatus());
            PRE.setTimestamp(5, dto.getCreateDate());
            PRE.setString(6, userID);

            check = PRE.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateDiscount(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE [dbo].[Discount] set discountStatus = 'inactive'\n"
                    + "WHERE discountID = ?";

            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, id);

            check = PRE.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    
}
