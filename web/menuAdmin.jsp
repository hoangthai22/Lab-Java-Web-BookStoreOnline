
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet"
              href="assets/vendor/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/vendor/linearicons/style.css">
        <!-- MAIN CSS -->
        <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
        <link rel="stylesheet" href="assets/css/demo.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <title>Menu Admin</title>
    </head>
    <style>
        .navbar {
            margin-bottom: 0px;
            height: 65px;
            border-radius: 0px;
            width: 90%;
            float: right;

        }
        #wrapper .sidebar {
            background-color: #2c3e50 !important;
        }
        .sidebar .nav > li > a{
            background-color: #2c3e50 !important;
        }
        .sidebar .nav > li > a {
            color: white; 
        }
        .dropdown-header{
            margin: auto;
        }
    </style>
    <body>
        <!-- NAVBAR --> 

        <nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: #2c3e50 !important;">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#!" style="font-size: 1.75em;
                   transition: font-size 0.3s;color: #fff; margin-left: -200px    ">Book Store</a>

            </div>


        </nav>
        <!-- END NAVBAR -->
        <!-- LEFT SIDEBAR -->
        <div id="sidebar-nav" class="sidebar">
            <div class="sidebar-scroll">

                <nav>
                    <ul class="nav">

                        <li><hr class="dropdown-header" /></li>
                        <li> <a href="MainController?action=ManageUser"  class=""><i
                                    class="lnr lnr-home"></i> <span>Manage User</span>
                            </a>
                        </li>
                        <li><hr class="dropdown-header"/></li>
                        <li><a href="MainController?action=ManageOrder" class=""><i class="lnr lnr-list"></i>
                                <span>Manage Order</span></a>
                        </li>
                        <li><hr class="dropdown-header" /></li>
                        <li> <a href="MainController?action=ManageBook" class=""><i
                                    class="lnr lnr-book"></i> <span>Manage Book</span> </a>
                        </li>
                        <li><hr class="dropdown-header" /></li>
                        <br>
                    </ul>
                </nav>  
                <nav> 
                    <ul class="nav">
                        <li> <a data-toggle="collapse" class=""><i
                                    class="lnr lnr-user"></i> <span>${sessionScope.user.userFullName}</span>
                            </a>
                            <div id="subPages" class="collapse in">
                                <ul class="nav">
                                    <li><a href="MainController?action=Logout" class="">Logout</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </nav>

            </div>
        </div>  




    </body>
</html>
