/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thai.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thai.daos.BookDAO;
import thai.daos.CategoryDAO;
import thai.dtos.BookObj;
import thai.dtos.CategoryObj;
import static thai.utils.Constant.ADMIN_PAGE_EDIT_BOOK;
import static thai.utils.Constant.ERROR;
import static thai.utils.Constant.LOGGER;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "ShowInfoBookController", urlPatterns = {"/ShowInfoBookController"})
public class ShowInfoBookController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String id = request.getParameter("id");
            if (id == null) {
                id = "" + request.getAttribute("txtId");
            }
            BookDAO dao = new BookDAO();
            BookObj book = dao.getBookById(id);
            CategoryDAO catDao = new CategoryDAO();
            List<CategoryObj> categoryList = catDao.getCategory();
            if (book != null) {
                url = ADMIN_PAGE_EDIT_BOOK;
                String time = book.getBookCreateDate().substring(0, 10);
                book.setBookCreateDate(time);
                request.setAttribute("book", book);
                request.setAttribute("categoryList", categoryList);
            }
        } catch (Exception e) {
            LOGGER.info("ERROR at ShowInfoBookController:" + e.getMessage());

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