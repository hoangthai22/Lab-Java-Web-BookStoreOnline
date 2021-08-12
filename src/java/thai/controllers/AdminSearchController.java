/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thai.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thai.daos.OrderDAO;
import thai.dtos.OrderObj;
import thai.dtos.UserObj;
import static thai.utils.Constants.ADMIN_MANAGE_ORDER_PAGE;
import static thai.utils.Constants.ERROR;
import static thai.utils.Constants.LOGGER;
import static thai.utils.Constants.ORDER_HISTORY_PAGE;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "AdminSearchController", urlPatterns = {"/AdminSearchController"})
public class AdminSearchController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String name = request.getParameter("txtUserID");
            String dateStart = request.getParameter("txtDateStart");
            String dateEnd = request.getParameter("txtDateEnd");
            OrderDAO dao = new OrderDAO();
            List<OrderObj> listSearch = new ArrayList<>();
            HttpSession session = request.getSession();
            UserObj user = (UserObj) session.getAttribute("user");
            if (name != null) {
                listSearch = dao.searchOrder(name, "", "");
                request.setAttribute("search", name);
                url = ADMIN_MANAGE_ORDER_PAGE;
            } else {
                if (user.getUserRoleID().equals("AD")) {
                    listSearch = dao.searchOrder("", dateStart, dateEnd);
                    url = ADMIN_MANAGE_ORDER_PAGE;
                } else {
                    listSearch = dao.searchOrderUser(user.getUserID(), dateStart, dateEnd);
                    url = ORDER_HISTORY_PAGE;
                }
                request.setAttribute("dateStart", dateStart);
                request.setAttribute("dateEnd", dateEnd);
            }
            request.setAttribute("listOrder", listSearch);
           
        } catch (Exception e) {
            LOGGER.info("ERROR at AdminSearchController:" + e.getMessage());
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
