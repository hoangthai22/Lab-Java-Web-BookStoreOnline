/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thai.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thai.daos.BookDAO;
import thai.daos.CategoryDAO;
import thai.dtos.BookObj;
import thai.dtos.CategoryObj;
import thai.dtos.UserObj;
import static thai.utils.Constant.ADMIN_PAGE_BOOK;
import static thai.utils.Constant.ERROR;
import static thai.utils.Constant.HOME_PAGE;
import static thai.utils.Constant.LOGGER;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            UserObj user = (UserObj) session.getAttribute("user");
            BookDAO dao = new BookDAO();
            List<BookObj> bookList = dao.getAllBook();

            if (user != null) {
                if (user.getUserRoleID().equals("AD")) {
                    url = ADMIN_PAGE_BOOK;
                    bookList = dao.getAllBookAdmin();
                    CategoryDAO catDao = new CategoryDAO();
                    List<CategoryObj> cat = catDao.getCategory();
                    request.setAttribute("categoryList", cat);
                } else if (user.getUserRoleID().equals("US")) {
                    url = HOME_PAGE;
                }
            } else {
                url = HOME_PAGE;
            }

            if (bookList.size() > 0) {
                request.setAttribute("bookList", bookList);
            }
        } catch (Exception e) {
            LOGGER.info("ERROR at HomeController:" + e.getMessage());
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
