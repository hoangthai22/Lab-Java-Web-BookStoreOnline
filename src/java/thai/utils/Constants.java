/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thai.utils;

import org.apache.log4j.Logger;

/**
 *
 * @author ASUS
 */
public class Constants {

    public static final String LOGIN = "LoginController";
    public static final String LOGOUT = "LogoutController";
    public static final String HOME = "HomeController";
    public static final String DETAIL = "DetailBookController";
    public static final String SEARCH = "SearchController";
    public static final String SEARCH_PRICE = "SearchByPriceController";
    public static final String ADD_TO_CART = "AddToCartController";
    public static final String DELETE_FROM_CART = "DeleteCartController";
    public static final String UPDATE_CART = "UpdateCartController";
    public static final String USE_DISCOUNT = "UseDiscountController";
    public static final String DELETE_BOOK = "DeleteBookController";
    public static final String INSERT_BOOK = "InsertBookController";
    public static final String EDIT_BOOK = "EditBookController";
    public static final String SHOW_BOOK = "ShowInfoBookController";
    public static final String GET_USER = "GetAllUserController";
    public static final String CREATE_DISCOUNT = "CreateDiscountController";
    public static final String GET_ALL_ORDER = "GetAllOrderContoller";
    public static final String ADMIN_GET_ORDERDETAIL = "GetOrderDetailAdminController";
    public static final String USER_GET_ORDER = "GetAllOrderByUserController";
    public static final String PAYMENT = "PaymentController";
    public static final String AUTHORIZE_PAYMENT = "AuthorizePaymentController";
    public static final String REVIEW = "ReviewPaymentController";
    public static final String USER_GET_ORDERDETAIL = "GetOrderDetailUserController";
    public static final String GET_DISCOUNT = "GetDiscountController";
    public static final String SEARCH_ORDER = "AdminSearchController";
    public static final String SIGNUP = "RegistrationController";
    public static final String VERIFY = "VerifyController";

    public static final String ERROR = "error.jsp";
    public static final String DETAIL_PAGE = "detailBook.jsp";
    public static final String REGISTER = "register.jsp";
    public static final String LOGIN_PAGE = "login.jsp";
    public static final String HOME_PAGE = "index.jsp";
    public static final String CART_PAGE = "shoppingcart.jsp";
    public static final String ADMIN_PAGE = "manageAdmin.jsp";
    public static final String ADMIN_PAGE_BOOK = "manageBookAmin.jsp";
    public static final String ADMIN_PAGE_EDIT_BOOK = "edit.jsp";
    public static final String ADMIN_MANAGE_USER_PAGE = "manageUser.jsp";
    public static final String ADMIN_MANAGE_ORDER_PAGE = "manageOrder.jsp";
    public static final String ADMIN_ORDER_DETAIL_PAGE = "orderDetailAdmin.jsp";
    public static final String ORDER_HISTORY_PAGE = "orderHistory.jsp";
    public static final String REVIEW_PAGE = "review.jsp";
    public static final String HISTORY_DETAIL_PAGE = "orderHistoryDetail.jsp";
    public static final String MY_DISCOUNT_PAGE = "myDiscount.jsp";
    public static final Logger LOGGER = Logger.getLogger(Constants.class);

    /*-----------------*/
    public static String GOOGLE_CLIENT_ID = "200689241727-8o237eoignfnd84ffo7fguljup4vlfs6.apps.googleusercontent.com";
    public static String GOOGLE_CLIENT_SECRET = "Fgplm2J26r_vp1HMjlRfPmcs";
    public static String GOOGLE_REDIRECT_URI = "http://localhost:8181/J3.L.P0018.TheBookStore/LoginGoogleController";
    public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
    public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    public static String GOOGLE_GRANT_TYPE = "authorization_code";
}
