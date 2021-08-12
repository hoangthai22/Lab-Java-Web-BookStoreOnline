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
import thai.dtos.BookObj;
import thai.dtos.CartObj;
import static thai.utils.Constants.CART_PAGE;
import static thai.utils.Constants.DETAIL;
import static thai.utils.Constants.ERROR;
import static thai.utils.Constants.HOME;
import static thai.utils.Constants.LOGGER;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCartController"})
public class AddToCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String id = request.getParameter("id");
            String quantityCart = request.getParameter("quantityCart");
            HttpSession session = request.getSession();
            CartObj cart = (CartObj) session.getAttribute("cart");
            if (cart == null) {
                cart = new CartObj();
            }
            BookDAO bookDao = new BookDAO();
            BookObj dto = bookDao.getBookById(id);
            if (quantityCart == null) {
                dto.setBookQuantity(1);
                url = HOME;
                cart.addToCart(dto);

            } else {
                int quantity = Integer.parseInt(quantityCart);
                if (quantity <= dto.getBookQuantity()) {
                    url = CART_PAGE;
                    cart.updateCart(dto, Integer.parseInt(quantityCart));
                } else {
                    url = DETAIL;
                    request.setAttribute("errorQuantity", "The maximum purchase amount for this product is " + dto.getBookQuantity());
                    request.setAttribute("idError", id);
                }
            }
            session.setAttribute("cart", cart);
        } catch (Exception e) {
            LOGGER.info("ERROR at AddToCartController:" + e.getMessage());

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
