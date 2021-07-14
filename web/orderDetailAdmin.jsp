

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!doctype html>
<html>

    <head>
        <title>Order Detail</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 

        <link rel="stylesheet"
              href="assets/vendor/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/main.css">
        <link
            href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700"
            rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="assets/css/manager.css" rel="stylesheet" type="text/css"/>
    </head>
    <style>
        #wrapper > div.main > div.main-content > div > div > div:nth-child(1) > div > div > div > div > h3{
            font-size: 17px;
            font-weight: bold;
        }
    </style>
    <body>
        <!-- WRAPPER -->
        <div id="wrapper">
            <jsp:include page="menuAdmin.jsp"></jsp:include>

                <div class="main">
                    <!-- MAIN CONTENT -->
                    <div class="main-content">
                        <div class="container-fluid">

                            <div class="row">
                                <div class="col-md-12">

                                    <!-- TABLE STRIPED -->
                                    <div class="panel">

                                        <div class="container" style="width: 100%">
                                            <div class="table-wrapper">
                                                <div>
                                                    <h3>Order ID</h3>
                                                    <span>${requestScope.order.orderID}</span>
                                            </div>
                                            <div>
                                                <h3>Infomation</h3>
                                                <p>${requestScope.order.orderUser}</p>
                                                <p>${requestScope.order.orderAddress}</p>
                                                <p>${requestScope.order.orderPhone}</p>
                                            </div>

                                            <div>
                                                <h3>Payment</h3>
                                                <span>${requestScope.order.orderType}</span>
                                            </div>
                                            <div>
                                                <h3>Date of payment</h3>
                                                <span>${requestScope.order.orderDate}</span>
                                            </div>
                                        </div>

                                    </div>
                                </div>

                                <!-- END TABLE STRIPED -->
                            </div>
                            <div class="col-md-12">
                                <c:if test="">
                                    <div class="alert alert-danger alert-dismissible" role="alert">
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                        <i class="fa fa-times-circle"></i>
                                    </div>
                                </c:if>
                                <!-- TABLE STRIPED -->
                                <div class="panel">

                                    <div class="container" style="width: 100%">
                                        <div class="table-wrapper">
                                            <div class="table-title">
                                                <div class="row">
                                                    <div class="col-sm-6">
                                                        <h2>Order <b>Detail</b></h2>
                                                    </div>

                                                </div>
                                            </div>

                                            <table class="table table table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>STT</th>
                                                        <th>Product</th>
                                                        <th>Title</th>
                                                        <th>Price</th>
                                                        <th>Amount</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${requestScope.listBook}" var="o" varStatus="count">
                                                        <tr>
                                                            <td>${count.count}</td>
                                                            <td><img style="max-width: 20%;" src="${o.bookImage}"></td>
                                                            <td>${o.bookName}</td>
                                                            <td>${o.bookPrice}</td>
                                                            <td>${o.bookQuantity}</td>

                                                        </tr>

                                                    </c:forEach>    
                                                </tbody>
                                            </table>

                                        </div>
                                        <div>
                                            <h3 style="font-size: 18px;
                                                font-weight: bold; float: right; margin-right: 40px;">
                                                Total: ${requestScope.order.orderTotal} $
                                            </h3>
                                        </div>

                                    </div>
                                </div>

                                <!-- END TABLE STRIPED -->
                            </div>
                        </div>

                    </div>
                </div>
               

            </div>
            <!-- END MAIN -->
            <div class="clearfix"></div>

        </div>
        <script src="assets/js/manager.js" type="text/javascript"></script>
        
        <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
       
        <script src="assets/js/main.js"></script>
    </body>

</html>


