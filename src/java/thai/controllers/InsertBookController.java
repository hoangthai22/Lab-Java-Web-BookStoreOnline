/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thai.controllers;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import thai.daos.BookDAO;
import thai.dtos.BookObj;
import static thai.utils.Constant.ERROR;
import static thai.utils.Constant.HOME;
import static thai.utils.Constant.LOGGER;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "InsertBookController", urlPatterns = {"/InsertBookController"})
public class InsertBookController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String url = ERROR;
        try {
            boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
            if (isMultiPart) {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List items = null;
                try {
                    items = upload.parseRequest(request);
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }
                Iterator iter = items.iterator();
                Hashtable params = new Hashtable();
                BookDAO dao = new BookDAO();

                String fileName;
                String RealPath;
                String bookName, categoryID, bookAuthor, bookDescription, bookImage = "";
                float bookPrice;
                int bookQuantity;
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    if (item.isFormField()) {
                        params.put(item.getFieldName(), item.getString());
                    } else {
                        try {
                            String itemName = item.getName();
                            fileName = itemName.substring(itemName.lastIndexOf("\\") + 1);
                            RealPath = "C:\\Users\\ASUS\\Desktop\\LAB_WEB\\J3.L.P0018.TheBookStore\\web\\assets\\img\\" + fileName;
                            bookImage = "assets/img/" + fileName;
                            File savedFile = new File(RealPath);
                            if (!savedFile.exists()) {
                                item.write(savedFile);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                bookName = (String) params.get("txtName");
                categoryID = (String) params.get("txtCategory");
                bookDescription = (String) params.get("txtDescription");
                bookAuthor = (String) params.get("txtAuthor");
                bookPrice = Float.parseFloat((String) params.get("txtPrice"));
                bookQuantity = Integer.parseInt((String) params.get("txtQuantity"));
                Timestamp creatDate = Timestamp.valueOf(LocalDateTime.now());
               
                BookObj dto = new BookObj(bookName, "active", bookImage, bookPrice, bookQuantity, creatDate + "", categoryID, bookAuthor, bookDescription);
                if (dao.insertBook(dto)) {

                } else {
                    request.setAttribute("book", dto);
                }
                url = HOME;
            }

        } catch (Exception e) {
            LOGGER.info("ERROR at InsertBookController:" + e.getMessage());
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
