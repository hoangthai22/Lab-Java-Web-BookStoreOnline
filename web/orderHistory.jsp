

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order History</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="assets/css/styles.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"> 
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <link href="assets/css/manager.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <div class="shopping-cart">
                <div class="px-4 px-lg-0">

                    <div class="pb-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
                                <c:if test="${not empty requestScope.errorQuantity}">
                                    <div class="alert alert-danger alert-dismissible" role="alert">
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                        <i class="fa fa-times-circle"></i> ${requestScope.errorQuantity}
                                    </div>
                                </c:if>
                                <!-- Shopping cart table -->

                                <div class="table-responsive">

                                    <div class="panel">

                                        <div class="container" style="width: 100%">
                                            <div class="table-wrapper">
                                                <div class="table-title">
                                                    <div class="row">
                                                        <div class="col-sm-6">
                                                            <h2>Order <b>History</b></h2>
                                                        </div>
                                                    </div>
                                                </div>
                                                <br>
                                                <div >
                                                    <form action="MainController" method="post">
                                                        <input style="width: 150px;    height: 35px;" type="date" name="txtDateStart" value="${requestScope.dateStart}">
                                                        <input style="width: 150px;    height: 35px;" type="date" name="txtDateEnd" value="${requestScope.dateEnd}" >
                                                        <button style="border-radius: 8px; width: 100px;" type="submit" name="action" value="UserSearch" class="btn btn-secondary btn-number">Apply</button>
                                                    </form>
                                                    <br>

                                                </div>
                                                <br>
                                                <form action="MainController?action=UpdateCart" method="post">
                                                    <table class="table table table-hover">
                                                        <thead>
                                                            <tr>
                                                                <th>STT</th>
                                                                <th>OrderID</th>
                                                                <th>Date of payment</th>
                                                                <th>Total</th>
                                                                <th>Status</th
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${requestScope.listOrder}" var="o" varStatus="count">
                                                                <tr>
                                                                    <td>${count.count}</td>
                                                                    <td>${o.orderID}</td>
                                                                    <td>${o.orderDate}</td>
                                                                    <td>${o.orderTotal} $</td>
                                                                    <td style="text-align: center"><a style="color: white" class="btn btn-${o.orderStatus == 'Finish' ? 'success' : 'danger'}">${o.orderStatus}</a></td>
                                                                    <td><a href="MainController?action=ViewHistoryDetail&orderID=${o.orderID}" >View Detail</a></td>
                                                                </tr>

                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </form>
                                            </div>


                                        </div>
                                    </div>

                                </div>
                                <!-- End -->
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    </body>

</html>
</html>
