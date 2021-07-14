

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Detail</title> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="assets/css/styles.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"> 
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <link href="assets/css/manager.css" rel="stylesheet" type="text/css"/>

    </head>
    <style>
         .h3, h3{
                font-size: 1.25rem;
           
        }
    </style>
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
                                                                    <h5>Order ID</h5>
                                                                    <span>${requestScope.order.orderID}</span>
                                                                </div>
                                                                <br>
                                                                <div>
                                                                    <h5>Infomation</h5>
                                                                    <p>${requestScope.order.orderUser}</p>
                                                                    <p>${requestScope.order.orderAddress}</p>
                                                                    <p>${requestScope.order.orderPhone}</p>
                                                                </div>
                                                                <br>
                                                                <div>
                                                                    <h5>Payment</h5>
                                                                    <span>${requestScope.order.orderType}</span>
                                                                </div>
                                                                <br>
                                                                <div>
                                                                    <h5>Date of payment</h5>
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
                                    <div id="addEmployeeModal" class="modal fade">
                                        <div class="modal-dialog">
                                            <div class="modal-content" style="
                                                 width: 600px;
                                                 margin-left: -80px;">
                                                <form action="MainController?action=AddBook" method="post" id="testForm"
                                                      enctype="multipart/form-data" >
                                                    <div class="modal-header">						
                                                        <h4 class="modal-title">Add Product</h4>
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    </div>
                                                    <div class="modal-body">					
                                                        <div class="form-group">
                                                            <label>Title</label>
                                                            <input name="txtName" type="text" value="${not empty requestScope.book ? requestScope.book.bookName : ''}" class="form-control" required>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Image</label>
                                                            <input type = "file" name ="fileup" value="" style="width: 100%;" required/>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Price</label>
                                                            <input name="txtPrice" type="number" class="form-control" required>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Author</label>
                                                            <input name="txtAuthor" type="text" class="form-control" required>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Quantity</label>
                                                            <input name="txtQuantity" type="number" class="form-control" required>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Description</label>
                                                            <textarea name="txtDescription" class="form-control" required></textarea>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Category</label>
                                                            <select name="txtCategory" class="form-select" aria-label="Default select example">
                                                                <c:forEach items="${requestScope.categoryList}" var="o">
                                                                    <option value="${o.categoryID}">${o.categoryName}</option>

                                                                </c:forEach>
                                                            </select>
                                                        </div>

                                                    </div>
                                                    <div class="modal-footer">
                                                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                                        <input type="submit" class="btn btn-success" value="Add">
                                                    </div>
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
