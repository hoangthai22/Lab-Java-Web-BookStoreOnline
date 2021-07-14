

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MY DISCOUNT</title>
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
                                    <form action="MainController?action=UpdateCart" method="post">
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
                                                    <table class="table table table-hover">
                                                        <thead>
                                                            <tr>
                                                                <th>STT</th>
                                                                <th>Discount code</th>
                                                                <th>Description</th>

                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${requestScope.listDiscount}" var="o" varStatus="count">
                                                                <tr>
                                                                    <td>${count.count}</td>
                                                                    <td>${o.discountID}</td>
                                                                    <td>${o.discountName}</td>
                                                                      </tr>

                                                            </c:forEach>
                                                        </tbody>
                                                    </table>

                                                </div>


                                            </div>
                                        </div>
                                    </form>
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
