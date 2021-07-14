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
import thai.dtos.UserObj;
import static thai.utils.Constant.ADD_TO_CART;
import static thai.utils.Constant.ADMIN_GET_ORDERDETAIL;

import static thai.utils.Constant.AUTHORIZE_PAYMENT;
import static thai.utils.Constant.CART_PAGE;
import static thai.utils.Constant.CREATE_DISCOUNT;
import static thai.utils.Constant.DELETE_BOOK;
import static thai.utils.Constant.DELETE_FROM_CART;
import static thai.utils.Constant.DETAIL;
import static thai.utils.Constant.EDIT_BOOK;
import static thai.utils.Constant.ERROR;
import static thai.utils.Constant.GET_ALL_ORDER;
import static thai.utils.Constant.GET_DISCOUNT;
import static thai.utils.Constant.GET_USER;
import static thai.utils.Constant.HOME;
import static thai.utils.Constant.INSERT_BOOK;
import static thai.utils.Constant.LOGGER;
import static thai.utils.Constant.LOGIN;
import static thai.utils.Constant.LOGIN_PAGE;
import static thai.utils.Constant.LOGOUT;
import static thai.utils.Constant.PAYMENT;
import static thai.utils.Constant.REGISTER;
import static thai.utils.Constant.REVIEW;
import static thai.utils.Constant.SEARCH;
import static thai.utils.Constant.SEARCH_ORDER;
import static thai.utils.Constant.SEARCH_PRICE;
import static thai.utils.Constant.SHOW_BOOK;
import static thai.utils.Constant.UPDATE_CART;
import static thai.utils.Constant.USER_GET_ORDER;
import static thai.utils.Constant.USER_GET_ORDERDETAIL;
import static thai.utils.Constant.USE_DISCOUNT;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (action.equals("Login")) {
                url = LOGIN;
            } else if (action.equals("Register")) {
                url = REGISTER;
            } else if (action.equals("LoginPage")) {
                url = LOGIN_PAGE;
            } else if (action.equals("Logout")) {
                url = LOGOUT;
            } else if (action.equals("ViewHome")) {
                url = HOME;
            } else if (action.equals("SearchByPrice")) {
                url = SEARCH_PRICE;
            } else if (action.equals("SearchByCategory") || action.equals("SearchByName")) {
                url = SEARCH;
            } else if (action.equals("ViewCart")) {
                url = CART_PAGE;
            } else if (action.equals("DeleteCart")) {
                url = DELETE_FROM_CART;
            } else if (action.equals("UpdateCart")) {
                url = UPDATE_CART;
            } else if (action.equals("AddToCart") || action.equals("AddToCartFromDetail")) {
                url = ADD_TO_CART;
            } else if (action.equals("DetailBook")) {
                url = DETAIL;
            } else {
                HttpSession session = request.getSession();
                UserObj user = (UserObj) session.getAttribute("user");
                if (user != null) {
                    if (user.getUserRoleID().equals("AD")) {
                        if (action.equals("ManageBook")) {
                            url = HOME;
                        } else if (action.equals("Delete")) {
                            url = DELETE_BOOK;
                        } else if (action.equals("AddBook")) {
                            url = INSERT_BOOK;
                        } else if (action.equals("EditBook")) {
                            url = EDIT_BOOK;
                        } else if (action.equals("ShowBook")) {
                            url = SHOW_BOOK;
                        } else if (action.equals("ManageUser")) {
                            url = GET_USER;
                        } else if (action.equals("CreateDiscount")) {
                            url = CREATE_DISCOUNT;
                        } else if (action.equals("ManageOrder")) {
                            url = GET_ALL_ORDER;
                        } else if (action.equals("ViewOrderDetail")) {
                            url = ADMIN_GET_ORDERDETAIL;
                        } else if (action.equals("AdminSearch")) {
                            url = SEARCH_ORDER;
                        }
                    } else if (user.getUserRoleID().equals("US")) {
                        if (action.equals("Apply")) {
                            url = USE_DISCOUNT;
                            request.setAttribute("action", action);
                        } else if (action.equals("RemoveDiscount")) {
                            url = USE_DISCOUNT;
                            request.setAttribute("action", action);
                        } else if (action.equals("Buy")) {
                            String payment = request.getParameter("checkout");
                            if (payment.equals("PaymentDelivery")) {
                                url = PAYMENT;
                            } else {
                                url = AUTHORIZE_PAYMENT;
                            }
                        } else if (action.equals("ShowHistory")) {
                            url = USER_GET_ORDER;
                        } else if (action.equals("ReviewOrder")) {
                            url = REVIEW;
                        } else if (action.equals("Pay")) {
                            url = PAYMENT;
                        } else if (action.equals("ViewHistoryDetail")) {
                            url = USER_GET_ORDERDETAIL;
                        } else if (action.equals("ViewMyDiscount")) {
                            url = GET_DISCOUNT;
                        } else if (action.equals("UserSearch")) {
                            url = SEARCH_ORDER;
                        }
                    } else {
                        url = LOGIN_PAGE;
                    }
                } else {
                    url = LOGIN_PAGE;
                }

            }

        } catch (Exception e) {
            LOGGER.info("ERROR at MainController:" + e.getMessage());
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
