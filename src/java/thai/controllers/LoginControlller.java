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
import thai.daos.UserDAO;
import thai.dtos.UserObj;
import static thai.utils.Constants.ERROR;
import static thai.utils.Constants.HOME;
import static thai.utils.Constants.LOGGER;
import static thai.utils.Constants.LOGIN_PAGE;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginControlller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String url = ERROR;
        try {
            String verify = request.getParameter("g-recaptcha-response");
            String txtUsername = request.getParameter("txtUsername");
            String txtPassword = request.getParameter("txtPassword");
            UserDAO userDao = new UserDAO();
            UserObj user = userDao.checkLogin(txtUsername, txtPassword);
            System.out.println("verify: "+ verify);
            System.out.println(txtUsername);
            System.out.println(txtPassword);
            if (verify.equals("")) {
                request.setAttribute("txtUsername", txtUsername);
                request.setAttribute("error", "Please check the captcha!!");
                 url = LOGIN_PAGE;
            } else if (user.getUserID() != null && user.getUserStatus().equals("active")) {
                if (user.getUserRoleID().equals("US")) {
                    request.setAttribute("txtUsername", user.getUserID());
                }
                url = HOME;
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
            } else {
                url = LOGIN_PAGE;
                request.setAttribute("id", txtUsername);
                request.setAttribute("error", "Username or password is invalid!!");
            }

        } catch (Exception e) {
            LOGGER.info("ERROR at LoginControlller:" + e.getMessage());
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
