package thai.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thai.daos.BookDAO;
import thai.daos.OrderDAO;
import thai.dtos.BookObj;
import thai.dtos.OrderDetailObj;
import thai.dtos.OrderObj;
import static thai.utils.Constants.ERROR;
import static thai.utils.Constants.HISTORY_DETAIL_PAGE;
import static thai.utils.Constants.LOGGER;

/**
 *
 * @author ASUS
 */
@WebServlet(urlPatterns = {"/GetOrderDetailUserController"})
public class GetOrderDetailUserController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String orderID = request.getParameter("orderID");
            OrderDAO dao = new OrderDAO();
            List<OrderDetailObj> orderDetailList = dao.getOrderDetailByOrderID(orderID);
            
            BookDAO bookDao = new BookDAO();
            List<BookObj> bookList = new ArrayList<>();
            for (OrderDetailObj orderDetailObj : orderDetailList) {
                BookObj book = bookDao.getBookById(orderDetailObj.getBookID() + "");
                book.setBookQuantity(orderDetailObj.getAmount());
                bookList.add(book);
            }
            OrderObj order = dao.getOrderByID(orderID);
            request.setAttribute("listBook", bookList);
            request.setAttribute("order", order);
            url = HISTORY_DETAIL_PAGE;
        } catch (Exception e) {
            LOGGER.info("ERROR at GetOrderDetailUserController:" + e.getMessage());
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
