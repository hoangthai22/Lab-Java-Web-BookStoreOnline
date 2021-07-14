/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thai.controllers;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thai.dtos.CartObj;
import thai.dtos.OrderObj;
import thai.dtos.PaymentServices;
import thai.dtos.UserObj;
import static thai.utils.Constant.ERROR;
import static thai.utils.Constant.LOGGER;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "AuthorizePaymentController", urlPatterns = {"/AuthorizePaymentController"})
public class AuthorizePaymentController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            float tax = 2;
            float ship = 3;
            HttpSession session = request.getSession();
            CartObj cart = (CartObj) session.getAttribute("cart");
            UserObj user = (UserObj) session.getAttribute("user");
            Date time = new Date();
            int userID = user.getUserID().hashCode() < 0 ? user.getUserID().hashCode() * -1 : user.getUserID().hashCode();
            String orderID = "" + time.getTime() + userID;
            OrderObj order = new OrderObj(orderID, user.getUserID(), (float) cart.getTotalPrice(), (float) cart.getTotalPriceByDiscount(0), tax, ship);
            order.setOrderDiscount(cart.getDiscount() != null ? cart.getTotalPriceByDiscount(cart.getDiscount().getDiscountPercent()) + "" : "0");
            PaymentServices paymentServices = new PaymentServices();
            String approvalLink = paymentServices.authorizePayment(order);
            url = approvalLink;

        } catch (Exception e) {
            LOGGER.info("ERROR at AuthorizePaymentController:" + e.getMessage());
        } finally {
            response.sendRedirect(url);
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
