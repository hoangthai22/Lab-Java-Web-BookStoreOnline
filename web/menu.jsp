<%-- 
    Document   : menu
    Created on : Jun 22, 2021, 2:50:20 PM
    Author     : ASUS
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"> 
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Menu</title>
    </head>
    <style> 
        .bg-dark {
            background-color: dimgrey;
        }
        .navbar-light .navbar-nav .nav-link {
            font-size: 1.3em;
            transition: font-size 0.3s;
            color: #fff;
        }
        .mt-lg-0, .my-lg-0 {
            margin-right: 240px; 
        }
    </style>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: #2c3e50 !important;">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="MainController?action=ViewHome" style="font-size: 1.75em;
                   transition: font-size 0.3s;color: #fff;">Book Store</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><img style="width: 26px;" class="hamburger-menu" src="https://salt.tikicdn.com/ts/upload/96/d1/77/e499ea39b0773a337d2217ad473fcb97.png">Category</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><i class="lnr lnr-home"></i><a href="MainController?action=ViewHome"  class="dropdown-item" href="#!">All Book</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="MainController?action=SearchByCategory&categoryName=Novel">Novel</a></li>
                                <li><a class="dropdown-item" href="MainController?action=SearchByCategory&categoryName=Arts and Literature">Arts and Literature</a></li>
                                <li><a class="dropdown-item" href="MainController?action=SearchByCategory&categoryName=Children's books">Children's books</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form action="MainController" method="post" class="form-inline my-2 my-lg-0" style="">
                        <div class="input-group input-group-sm">
                            <input name="txtSearchByName" type="text" required="" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number" name="action" value="SearchByName">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <form class="d-flex">
                        <a href="MainController?action=ViewCart" class="btn btn-outline-dark" type="submit"  style="color: aliceblue;">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.cart.cart == null ? '0' : sessionScope.cart.cart.size() }</span>
                        </a>
                        <div class="nav-item dropdown">
                            <a href="#" style="color: white" data-toggle="dropdown" class="nav-item nav-link dropdown-toggle user-action"><img src="https://salt.tikicdn.com/ts/upload/67/de/1e/90e54b0a7a59948dd910ba50954c702e.png" style="    width: 25px;" class="avatar" alt="Avatar"> 
                                ${not empty sessionScope.user ? sessionScope.user.userFullName : 'Login/Register'} <b class="caret"></b></a>
                            <div class="dropdown-menu">
                                <c:if test="${not empty sessionScope.user}">
                                    <a href="MainController?action=ShowHistory" class="dropdown-item"><i class="fa fa-calendar-o"></i> My order</a>
                                    <a href="MainController?action=ViewMyDiscount" class="dropdown-item"><i class="fa fa-sliders"></i> My discount code</a>
                                    <div class="divider dropdown-divider"></div>
                                </c:if>
                                <a href="MainController?action=${not empty sessionScope.user ? 'Logout' : 'LoginPage'}" class="dropdown-item">${not empty sessionScope.user ? 'Logout' : 'Login'} </a>

                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </nav>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </body>

</html>
