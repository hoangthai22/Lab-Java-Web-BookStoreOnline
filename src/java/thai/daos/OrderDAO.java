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
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import thai.dtos.OrderDetailObj;
import thai.dtos.OrderObj;
import static thai.utils.Constant.LOGGER;
import thai.utils.DBUtil;

/**
 *
 * @author ASUS
 */
public class OrderDAO {

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

    public List<OrderObj> getAllOrder() throws SQLException, NamingException {
        List<OrderObj> result = new ArrayList<>();

        try {
            String sql = "SELECT orderID, userID, orderDate, orderStatus, orderAddress, orderPhone,orderTotal,discountID,orderType\n"
                    + "FROM [dbo].[Order]\n"
                    + "ORDER BY orderDate DESC";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            RS = PRE.executeQuery();
            while (RS.next()) {
                String orderID = RS.getString("orderID");
                String userID = RS.getString("userID");
                Timestamp orderDate = RS.getTimestamp("orderDate");
                String orderStatus = RS.getString("orderStatus");
                String orderAddress = RS.getString("orderAddress");
                String orderPhone = RS.getString("orderPhone");
                float orderTotal = RS.getFloat("orderTotal");
                String discountID = RS.getString("discountID");
                String orderType = RS.getString("orderType");
                OrderObj user = new OrderObj(orderID, userID, orderDate, orderStatus, orderAddress, orderPhone, orderTotal, discountID, orderType);
                result.add(user);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<OrderObj> getAllOrderByUser(String userID) throws SQLException, NamingException {
        List<OrderObj> result = new ArrayList<>();

        try {
            String sql = "SELECT orderID, orderDate, orderStatus, orderAddress, orderPhone,orderTotal,discountID,orderType\n"
                    + "FROM [dbo].[Order]\n"
                    + "WHERE userID = ?\n"
                    + "ORDER BY orderDate DESC";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, userID);
            RS = PRE.executeQuery();
            while (RS.next()) {
                String orderID = RS.getString("orderID");
                Timestamp orderDate = RS.getTimestamp("orderDate");
                String orderStatus = RS.getString("orderStatus");
                String orderAddress = RS.getString("orderAddress");
                String orderPhone = RS.getString("orderPhone");
                float orderTotal = RS.getFloat("orderTotal");
                String discountID = RS.getString("discountID");
                String orderType = RS.getString("orderType");
                OrderObj user = new OrderObj(orderID, userID, orderDate, orderStatus, orderAddress, orderPhone, orderTotal, discountID, orderType);
                result.add(user);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<OrderDetailObj> getOrderDetailByOrderID(String id) throws SQLException, NamingException {
        List<OrderDetailObj> result = new ArrayList<>();

        try {
            String sql = "SELECT orderDetailID, orderID, bookID, amount\n"
                    + "FROM [dbo].[OrderDetail]\n"
                    + "WHERE orderID = ?";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, id);
            RS = PRE.executeQuery();
            while (RS.next()) {
                String orderDetailID = RS.getString("orderDetailID");
                String orderID = RS.getString("orderID");
                int bookID = RS.getInt("bookID");
                int amount = RS.getInt("amount");
                OrderDetailObj user = new OrderDetailObj(orderDetailID, orderID, bookID, amount);
                result.add(user);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<OrderObj> searchOrder(String name, String dateStart, String dateEnd) throws SQLException, NamingException {
        List<OrderObj> result = new ArrayList<>();
        String search;
        if (!name.equals("")) {
            search = " WHERE userID LIKE ?";
        } else {
            search = " WHERE orderDate >= ? and  orderDate <= ?";
        }
        try {
            String sql = "SELECT orderID, userID, orderDate, orderStatus, orderAddress, orderPhone,orderTotal,discountID,orderType\n"
                    + "FROM [dbo].[Order]\n" + search + "\n"
                    + "ORDER BY orderDate DESC";

            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            if (!name.equals("")) {
                PRE.setString(1, "%" + name + "%");
            } else {
                PRE.setString(1, dateStart);
                PRE.setString(2, dateEnd);
            }
            RS = PRE.executeQuery();
            while (RS.next()) {
                String orderID = RS.getString("orderID");
                String userID = RS.getString("userID");
                Timestamp orderDate = RS.getTimestamp("orderDate");
                String orderStatus = RS.getString("orderStatus");
                String orderAddress = RS.getString("orderAddress");
                String orderPhone = RS.getString("orderPhone");
                float orderTotal = RS.getFloat("orderTotal");
                String discountID = RS.getString("discountID");
                String orderType = RS.getString("orderType");
                OrderObj user = new OrderObj(orderID, userID, orderDate, orderStatus, orderAddress, orderPhone, orderTotal, discountID, orderType);
                result.add(user);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<OrderObj> searchOrderUser(String name, String dateStart, String dateEnd) throws SQLException, NamingException {
        List<OrderObj> result = new ArrayList<>();
        try {
            String sql = "SELECT orderID, userID, orderDate, orderStatus, orderAddress, orderPhone,orderTotal,discountID,orderType\n"
                    + "FROM [dbo].[Order]\n"
                    + "WHERE userID = ? AND orderDate >= ? and  orderDate <= ? \n"
                    + "ORDER BY orderDate DESC";

            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);

            PRE.setString(1, name);
            PRE.setString(2, dateStart);
            PRE.setString(3, dateEnd);
            RS = PRE.executeQuery();
            while (RS.next()) {
                String orderID = RS.getString("orderID");
                String userID = RS.getString("userID");
                Timestamp orderDate = RS.getTimestamp("orderDate");
                String orderStatus = RS.getString("orderStatus");
                String orderAddress = RS.getString("orderAddress");
                String orderPhone = RS.getString("orderPhone");
                float orderTotal = RS.getFloat("orderTotal");
                String discountID = RS.getString("discountID");
                String orderType = RS.getString("orderType");
                OrderObj user = new OrderObj(orderID, userID, orderDate, orderStatus, orderAddress, orderPhone, orderTotal, discountID, orderType);
                result.add(user);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public OrderObj getOrderByID(String id) throws SQLException, NamingException {
        OrderObj result = null;

        try {
            String sql = "SELECT orderID, userID, orderDate, orderStatus, orderAddress, orderPhone,orderTotal,discountID,orderType\n"
                    + "FROM [dbo].[Order]\n"
                    + "WHERE orderID = ?";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, id);
            RS = PRE.executeQuery();
            if (RS.next()) {
                String orderID = RS.getString("orderID");
                String userID = RS.getString("userID");
                Timestamp orderDate = RS.getTimestamp("orderDate");
                String orderStatus = RS.getString("orderStatus");
                String orderAddress = RS.getString("orderAddress");
                String orderPhone = RS.getString("orderPhone");
                float orderTotal = RS.getFloat("orderTotal");
                String discountID = RS.getString("discountID");
                String orderType = RS.getString("orderType");
                result = new OrderObj(orderID, userID, orderDate, orderStatus, orderAddress, orderPhone, orderTotal, discountID, orderType);

            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insertOrder(OrderObj dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO [dbo].[Order] (orderID ,[userID], [orderDate], [orderStatus], [orderAddress], [orderPhone], [orderTotal], [discountID], [orderType])\n"
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, dto.getOrderID());
            PRE.setString(2, dto.getOrderUser());
            PRE.setTimestamp(3, dto.getOrderDate());
            PRE.setString(4, dto.getOrderStatus());
            PRE.setString(5, dto.getOrderAddress());
            PRE.setString(6, dto.getOrderPhone());
            PRE.setFloat(7, dto.getOrderTotal());
            PRE.setString(8, dto.getOrderDiscount());
            PRE.setString(9, dto.getOrderType());
            check = PRE.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insertOrderDetail(OrderDetailObj dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO [dbo].[OrderDetail] (orderID, bookID, amount)\n"
                    + "VALUES (?,?,?)";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, dto.getOrderID());
            PRE.setInt(2, dto.getBookID());
            PRE.setInt(3, dto.getAmount());
            check = PRE.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

}
