/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thai.controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thai.daos.BookDAO;
import thai.daos.DiscountDAO;
import thai.daos.OrderDAO;
import thai.dtos.BookObj;
import thai.dtos.CartObj;
import thai.dtos.OrderDetailObj;
import thai.dtos.OrderObj;
import thai.dtos.UserObj;
import static thai.utils.Constants.CART_PAGE;
import static thai.utils.Constants.ERROR;
import static thai.utils.Constants.LOGGER;
import static thai.utils.Constants.USER_GET_ORDER;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "PaymentController", urlPatterns = {"/PaymentController"})
public class PaymentController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String paymentType = request.getParameter("checkout");
            String address = request.getParameter("txtAdress");
            String phone = request.getParameter("txtPhone");
            if (paymentType != null) {
                HttpSession session = request.getSession();
                CartObj cart = (CartObj) session.getAttribute("cart");
                UserObj user = (UserObj) session.getAttribute("user");
                if (cart != null && user != null) {
                    if (cart.getCart().size() > 0) {
                        OrderDAO dao = new OrderDAO();
                        BookDAO bookDao = new BookDAO();
                        boolean checkQuantity = true;
                        for (Map.Entry<Integer, BookObj> listCart : cart.getCart().entrySet()) {
                            if (bookDao.getBookById(listCart.getKey() + "").getBookQuantity() < listCart.getValue().getBookQuantity()) {
                                checkQuantity = false;
                            }
                        }
                        if (checkQuantity) {
                            Timestamp creatDate = Timestamp.valueOf(LocalDateTime.now());
                            float total = (float) cart.getTotalPrice();
                            String discountID = cart.getDiscount() != null ? cart.getDiscount().getDiscountID() : null;
                            Date time = new Date();
                            int userID = user.getUserID().hashCode() < 0 ? user.getUserID().hashCode() * -1 : user.getUserID().hashCode();
                            String orderID = "" + time.getTime() + userID;
                            OrderObj order = new OrderObj(orderID, user.getUserID(), creatDate, "Finish", address, phone, total, discountID, paymentType.equals("PaymentDelivery") ? "Payment on delivery" : "Online Payment");

                            if (dao.insertOrder(order)) {
                                for (Map.Entry<Integer, BookObj> listCart : cart.getCart().entrySet()) {
                                    OrderDetailObj orderDetail = new OrderDetailObj(orderID, listCart.getKey(), listCart.getValue().getBookQuantity());
                                    dao.insertOrderDetail(orderDetail);
                                    bookDao.updateQuantityDecrease(listCart.getKey(), listCart.getValue().getBookQuantity());
                                }
                                DiscountDAO discountDao = new DiscountDAO();
                                if (discountID != null) {
                                    discountDao.updateDiscount(discountID);
                                }
                                session.removeAttribute("cart");
                                url = USER_GET_ORDER;
                            }
                        }else {
                            url = CART_PAGE;
                            request.setAttribute("errorQuantity", "Out of stock");
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.info("ERROR at PaymentController:" + e.getMessage());
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
