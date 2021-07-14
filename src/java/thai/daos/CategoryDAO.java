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
import thai.dtos.CategoryObj;
import static thai.utils.Constant.LOGGER;
import thai.utils.DBUtil;

/**
 *
 * @author ASUS
 */
public class CategoryDAO {

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
            LOGGER.info("ERROR at CategoryDAO:" + e.getMessage());
        }
    }

    public List<CategoryObj> getCategory() throws SQLException, NamingException {
        List<CategoryObj> result = new ArrayList<>();
        CategoryObj dto = null;
        try {
            String sql = "SELECT categoryID, categoryName\n"
                    + "FROM [dbo].[Category]\n";
            CONN = DBUtil.getMyConnection();
            PRE = CONN.prepareStatement(sql);
            RS = PRE.executeQuery();
            while (RS.next()) {
                String categoryID = RS.getString("categoryID");
                String categoryName = RS.getString("categoryName");
                dto = new CategoryObj(categoryID, categoryName);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
}
