/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thai.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thai.daos.BookDAO;
import thai.dtos.CartObj;
import static thai.utils.Constants.CART_PAGE;
import static thai.utils.Constants.ERROR;
import static thai.utils.Constants.LOGGER;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "UpdateCartController", urlPatterns = {"/UpdateCartController"})
public class UpdateCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String[] listQuantity = request.getParameterValues("txtQuantity");
            String[] listID = request.getParameterValues("listID");
            if (listQuantity != null) {
                HttpSession session = request.getSession();
                CartObj cart = (CartObj) session.getAttribute("cart");
                BookDAO bookDao = new BookDAO();
                for (int i = 0; i < listQuantity.length; i++) {
                    if (Integer.parseInt(listQuantity[i]) <= 0) {
                        request.setAttribute("errorQuantity", "Please enter the number greater than 0!! ");
                        cart.getCart().get(Integer.parseInt(listID[i])).setBookError(true);
                    } else if (Integer.parseInt(listQuantity[i]) <= bookDao.getBookById(listID[i]).getBookQuantity()) {
                        cart.updateCartByID(Integer.parseInt(listID[i]), Integer.parseInt(listQuantity[i]));
                        cart.getCart().get(Integer.parseInt(listID[i])).setBookError(false);
                    } else {
                        request.setAttribute("errorQuantity", "The maximum purchase amount for this product is " + bookDao.getBookById(listID[i]).getBookQuantity());
                        cart.getCart().get(Integer.parseInt(listID[i])).setBookError(true);
                    }

                }
            }
            url = CART_PAGE;
        } catch (Exception e) {
            LOGGER.info("ERROR at UpdateCartController:" + e.getMessage());
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
