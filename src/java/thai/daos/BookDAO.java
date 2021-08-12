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
import thai.dtos.BookObj;
import static thai.utils.Constants.LOGGER;
import thai.utils.DBUtil;

/**
 *
 * @author ASUS
 */
public class BookDAO {

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
            LOGGER.info("ERROR at BookDAO:" + e.getMessage());
        }
    }

    public List<BookObj> getAllBook() throws SQLException, NamingException {
        List<BookObj> result = new ArrayList<>();

        try {
            String sql = "SELECT [bookID], [bookName], [bookStatus], [bookImage], [bookPrice], [bookQuantity], [bookCreateDate],"
                    + "[Category].[categoryName], [bookAuthor], bookDescription\n"
                    + "FROM [dbo].[Book] JOIN [dbo].[Category] ON [Book].categoryID = [Category].categoryID\n"
                    + "WHERE bookStatus = 'active' AND bookQuantity > 0";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            RS = PRE.executeQuery();
            while (RS.next()) {
                int bookID = RS.getInt("bookID");
                String bookName = RS.getString("bookName");
                String bookStatus = RS.getString("bookStatus");
                String bookImage = RS.getString("bookImage");
                float bookPrice = RS.getFloat("bookPrice");
                int bookQuantity = RS.getInt("bookQuantity");
                String bookCreateDate = RS.getString("bookCreateDate");
                String categoryName = RS.getString("categoryName");
                String bookAuthor = RS.getString("bookAuthor");
                String bookDescription = RS.getString("bookDescription");
                BookObj book = new BookObj(bookID, bookName, bookStatus, bookImage, bookPrice, bookQuantity, bookCreateDate, categoryName, bookAuthor, bookDescription);
                result.add(book);
            }
        } finally {
            closeConnection();
        }

        return result;

    }

    public List<BookObj> getAllBookAdmin() throws SQLException, NamingException {
        List<BookObj> result = new ArrayList<>();

        try {
            String sql = "SELECT [bookID], [bookName], [bookStatus], [bookImage], [bookPrice], [bookQuantity], [bookCreateDate],"
                    + "[Category].[categoryName], [bookAuthor], bookDescription\n"
                    + "FROM [dbo].[Book] JOIN [dbo].[Category] ON [Book].categoryID = [Category].categoryID\n";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            RS = PRE.executeQuery();
            while (RS.next()) {
                int bookID = RS.getInt("bookID");
                String bookName = RS.getString("bookName");
                String bookStatus = RS.getString("bookStatus");
                String bookImage = RS.getString("bookImage");
                float bookPrice = RS.getFloat("bookPrice");
                int bookQuantity = RS.getInt("bookQuantity");
                String bookCreateDate = RS.getString("bookCreateDate");
                String categoryName = RS.getString("categoryName");
                String bookAuthor = RS.getString("bookAuthor");
                String bookDescription = RS.getString("bookDescription");
                BookObj book = new BookObj(bookID, bookName, bookStatus, bookImage, bookPrice, bookQuantity, bookCreateDate, categoryName, bookAuthor, bookDescription);
                result.add(book);
            }
        } finally {
            closeConnection();
        }

        return result;

    }

    public BookObj getBookById(String id) throws SQLException, NamingException {
        BookObj dto = new BookObj();
        try {
            String sql = "SELECT [bookID], [bookName], [bookStatus], [bookImage], [bookPrice], [bookQuantity],bookCreateDate,"
                    + "[Category].[categoryName], [bookAuthor], bookDescription\n"
                    + "FROM [dbo].[Book] JOIN [dbo].[Category] ON [Book].categoryID = [Category].categoryID\n"
                    + "WHERE [bookID] = ? AND bookStatus = 'active'";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, id);
            RS = PRE.executeQuery();

            if (RS.next()) {
                int bookID = RS.getInt("bookID");
                String bookName = RS.getString("bookName");
                String bookStatus = RS.getString("bookStatus");
                String bookImage = RS.getString("bookImage");
                float bookPrice = RS.getFloat("bookPrice");
                int bookQuantity = RS.getInt("bookQuantity");
                String categoryID = RS.getString("categoryName");
                String bookCreateDate = RS.getString("bookCreateDate");
                String bookAuthor = RS.getString("bookAuthor");
                String bookDescription = RS.getString("bookDescription");
                dto = new BookObj(bookID, bookName, bookStatus, bookImage, bookPrice, bookQuantity, bookCreateDate, categoryID, bookAuthor, bookDescription);
            }

        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<BookObj> findBook(String key, String category) throws Exception {
        List<BookObj> result = new ArrayList<>();
        BookObj dto = null;
        try {
            String sql = "SELECT [bookID], [bookName], [bookImage], [bookPrice], [Category].[categoryName]\n"
                    + "FROM [dbo].[Book] JOIN [dbo].[Category] ON [Book].categoryID = [Category].categoryID\n\n"
                    + "WHERE bookStatus = 'active' AND bookQuantity > 0";
            if (!key.equals("")) {
                sql = sql.concat(" AND [bookName] LIKE ? ");
            } else if (!category.equals("")) {
                sql = sql.concat(" AND [Category].[categoryName] LIKE ? ");
            }
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            if (!key.equals("")) {
                PRE.setString(1, "%" + key + "%");
            } else if (!category.equals("")) {
                PRE.setString(1, "%" + category + "%");
            }

            RS = PRE.executeQuery();
            while (RS.next()) {
                int bookID = RS.getInt("bookID");
                String bookName = RS.getString("bookName");
                String bookImage = RS.getString("bookImage");
                float bookPrice = RS.getFloat("bookPrice");
                String categoryID = RS.getString("categoryName");
                dto = new BookObj(bookID, bookName, bookImage, bookPrice, categoryID);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookObj> findByPrice(float start, float end) throws Exception {
        List<BookObj> result = new ArrayList<>();
        BookObj dto = null;
        try {
            String sql = "SELECT [bookID], [bookName], [bookImage], [bookPrice], [Category].[categoryName]\n"
                    + "FROM [dbo].[Book] JOIN [dbo].[Category] ON [Book].categoryID = [Category].categoryID\n"
                    + "WHERE bookPrice between ? and ? AND  bookStatus = 'active' AND bookQuantity > 0";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setFloat(1, start);
            PRE.setFloat(2, end);
            RS = PRE.executeQuery();
            while (RS.next()) {
                int bookID = RS.getInt("bookID");
                String bookName = RS.getString("bookName");
                String bookImage = RS.getString("bookImage");
                float bookPrice = RS.getFloat("bookPrice");
                String categoryName = RS.getString("categoryName");
                dto = new BookObj(bookID, bookName, bookImage, bookPrice, categoryName);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

   
    public boolean UpdateStatusBook(String id, String status) throws SQLException, NamingException {
        boolean result = false;
        String sql = "Update [dbo].[Book] set  bookStatus = ?\n"
                + "where bookID = ? ";

        try {
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, status.equals("inactive") ? "active" : "inactive");
            PRE.setString(2, id);

            result = PRE.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insertBook(BookObj dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO [dbo].[Book] ([bookName], [bookImage], bookQuantity, [bookPrice], [categoryID],bookCreateDate,[bookAuthor],[bookStatus],[bookDescription])\n"
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, dto.getBookName());
            PRE.setString(2, dto.getBookImage());
            PRE.setInt(3, dto.getBookQuantity());
            PRE.setFloat(4, dto.getBookPrice());
            PRE.setString(5, dto.getCategoryID());
            Timestamp timestamp = Timestamp.valueOf(dto.getBookCreateDate());
            PRE.setTimestamp(6, timestamp);
            PRE.setString(7, dto.getBookAuthor());
            PRE.setString(8, dto.getBookStatus());
            PRE.setString(9, dto.getBookDescription());

            check = PRE.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updateBook(BookObj book) throws Exception {
        boolean result = false;
        String sql = "Update [dbo].[Book] set [bookName] = ?,[bookImage] = ?,[bookQuantity] = ?,[bookPrice] = ?,[categoryID] = ?,[bookCreateDate] = ?,"
                + "bookAuthor = ? , bookDescription = ? \n"
                + "where bookID = ?";
        try {
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setString(1, book.getBookName());
            PRE.setString(2, book.getBookImage());
            PRE.setInt(3, book.getBookQuantity());
            PRE.setFloat(4, book.getBookPrice());
            PRE.setString(5, book.getCategoryID());
            PRE.setString(6, book.getBookCreateDate());
            PRE.setString(7, book.getBookAuthor());
            PRE.setString(8, book.getBookDescription());
            PRE.setInt(9, book.getBookID());
            result = PRE.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return result;
    }


    public boolean updateQuantityDecrease(int id, int quantity) throws Exception {
        boolean result = false;
        String sql = "Update [dbo].[Book] set bookQuantity = bookQuantity - ?\n"
                + "where bookID = ?";
        try {
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setInt(1, quantity);
            PRE.setInt(2, id);
            result = PRE.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean updateQuantityIncrease(int id, int quantity) throws Exception {
        boolean result = false;
        String sql = "Update [dbo].[Book] set bookQuantity = bookQuantity + ?\n"
                + "where bookID = ?";
        try {
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            PRE.setInt(1, quantity);
            PRE.setInt(2, id);
            result = PRE.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return result;
    }
    
}
