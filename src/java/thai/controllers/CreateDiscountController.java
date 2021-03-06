/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thai.controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thai.daos.DiscountDAO;
import thai.dtos.DiscountObj;
import static thai.utils.Constants.ERROR;
import static thai.utils.Constants.GET_USER;
import static thai.utils.Constants.LOGGER;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "CreateDiscountController", urlPatterns = {"/CreateDiscountController"})
public class CreateDiscountController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String txtID = request.getParameter("txtID");
            String txtDiscountCode = request.getParameter("txtDiscountCode");
            String txtDiscountName = request.getParameter("txtDiscountName");
            String txtDiscountPercent = request.getParameter("txtDiscountPercent");
            DiscountDAO dao = new DiscountDAO();
            Timestamp creatDate = Timestamp.valueOf(LocalDateTime.now());
            DiscountObj discount = new DiscountObj(txtDiscountCode, txtDiscountName, Float.parseFloat(txtDiscountPercent), "active", creatDate);
            if(dao.insertDiscount(discount, txtID)){
                url = GET_USER;
            }
        } catch (Exception e) {
            LOGGER.info("ERROR at CreateDiscountController:" + e.getMessage());
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
