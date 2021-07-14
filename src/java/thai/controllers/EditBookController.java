/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thai.controllers;

import java.io.File;
import java.io.IOException;
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
import thai.daos.CategoryDAO;
import thai.dtos.BookObj;
import thai.dtos.CategoryObj;
import static thai.utils.Constant.ERROR;
import static thai.utils.Constant.LOGGER;
import static thai.utils.Constant.SHOW_BOOK;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "EditBookController", urlPatterns = {"/EditBookController"})
public class EditBookController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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

                String fileName = "";
                String RealPath;
                String bookImg = "";

                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    if (item.isFormField()) {
                        params.put(item.getFieldName(), item.getString());
                    } else {
                        try {
                            String itemName = item.getName();
                            fileName = itemName.substring(itemName.lastIndexOf("\\") + 1);
                            RealPath = "C:\\Users\\ASUS\\Desktop\\LAB_WEB\\J3.L.P0018.TheBookStore\\web\\assets\\img\\" + fileName;
                            bookImg = "assets/img/" + fileName;
                            File savedFile = new File(RealPath);
                            if (!savedFile.exists()) {
                                item.write(savedFile);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                int bookID = Integer.parseInt((String) params.get("txtID"));
                String bookName = (String) params.get("txtName");
                String category = (String) params.get("txtCategory");
                String bookDescription = (String) params.get("txtDescription");
                String bookAuthor = (String) params.get("txtAuthor");
                String bookDate = (String) params.get("txtDate");
                float bookPrice = Float.parseFloat((String) params.get("txtPrice"));
                int bookQuantity = Integer.parseInt((String) params.get("txtQuantity"));
                String txtImgOld = (String) params.get("txtImgOld");
                if (fileName.equals("")) {
                    bookImg = txtImgOld;
                }
                CategoryDAO catDao = new CategoryDAO();
                List<CategoryObj> categoryList = catDao.getCategory();
                for (CategoryObj categoryObj : categoryList) {
                    if (categoryObj.getCategoryName().equals(category)) {
                        category = categoryObj.getCategoryID();
                    }
                }
                BookObj dto = new BookObj(bookID, bookName, "", bookImg, bookPrice, bookQuantity, bookDate, category, bookAuthor, bookDescription);
                if (dao.updateBook(dto)) {

                } else {
                    request.setAttribute("error", "Edit Fail!!");
                }
                request.setAttribute("txtId", dto.getBookID());
                url = SHOW_BOOK;
            }
        } catch (Exception e) {
            LOGGER.info("ERROR at EditBookController:" + e.getMessage());
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
