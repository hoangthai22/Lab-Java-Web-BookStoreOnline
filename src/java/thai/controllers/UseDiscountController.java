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
import thai.daos.DiscountDAO;
import thai.dtos.CartObj;
import thai.dtos.DiscountObj;
import thai.dtos.UserObj;
import static thai.utils.Constant.CART_PAGE;
import static thai.utils.Constant.ERROR;
import static thai.utils.Constant.LOGGER;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "UseDiscountController", urlPatterns = {"/UseDiscountController"})
public class UseDiscountController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String discount = request.getParameter("txtDiscount");
            String action = (String) request.getAttribute("action");
            HttpSession session = request.getSession();
            CartObj cart = (CartObj) session.getAttribute("cart");
            if (!discount.isEmpty()) {
                if (action.equals("RemoveDiscount")) {
                    cart.setDiscount(null);
                } else {
                    UserObj user = (UserObj) session.getAttribute("user");

                    if (user != null) {
                        DiscountDAO discountDao = new DiscountDAO();
                        DiscountObj discountObj = discountDao.getDiscountByDiscountID(discount, user.getUserID());
                        if (discountObj.getDiscountID() != null) {
                            if (cart != null) {
                                cart.setDiscount(discountObj);
                            }
                            request.setAttribute("discount", discount);
                        } else {
                            request.setAttribute("error", "Not found");
                        }
                    }
                }
            }
            url = CART_PAGE;
        } catch (Exception e) {
            LOGGER.info("ERROR at UseDiscountController:" + e.getMessage());
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
