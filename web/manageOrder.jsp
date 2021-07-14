

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!doctype html>
<html>

    <head>
        <title>Manage Order</title>
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
                                                        <h2>Manage <b>Order</b></h2>
                                                    </div>

                                                </div>
                                            </div>
                                            <table class="table table table-hover">
                                                <br>

                                                <div >
                                                    <div>
                                                        <form action="MainController?action=AdminSearch" method="post">
                                                            <input style="width: 150px;    height: 35px;" required="" type="date" name="txtDateStart" value="${requestScope.dateStart}">
                                                            <input style="width: 150px;    height: 35px;" required=""  type="date" name="txtDateEnd" value="${requestScope.dateEnd}" >
                                                            <button style="border-radius: 8px; width: 100px;" type="submit" class="btn btn-secondary btn-number" name="action" value="SearchByPrice">Apply</button>
                                                        </form>    
                                                    </div>
                                                    <br> 
                                                    <div>
                                                        <form action="MainController?action=AdminSearch" method="post">
                                                            <input required=""  style="width: 150px;  border-radius: 5px;   height: 35px;" type="text" name="txtUserID" value="${requestScope.search}">
                                                            <button style="border-radius: 8px; width: 100px;" type="submit" class="btn btn-secondary btn-number" name="action" value="SearchByPrice">Apply</button>
                                                        </form>
                                                    </div>
                                                </div>



                                                <br>

                                                <thead>
                                                    <tr>
                                                        <th>STT</th>

                                                        <th>OrderID</th>
                                                        <th>User</th>
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
                                                            <td>${o.orderUser}</td>
                                                            <td>${o.orderDate}</td>
                                                            <td>${o.orderTotal} $</td>
                                                            <td style="text-align: center"><a style="color: white" class="btn btn-${o.orderStatus == 'Finish' ? 'success' : 'danger'}">${o.orderStatus}</a></td>
                                                            <td><a href="MainController?action=ViewOrderDetail&orderID=${o.orderID}" >View Detail</a></td>
                                                        </tr>

                                                    </c:forEach>
                                                </tbody>
                                            </table>

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
            <!-- END MAIN -->
            <div class="clearfix"></div>

        </div>
        <script src="assets/js/manager.js" type="text/javascript"></script>
        <script src="assets/vendor/jquery/jquery.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
        <script src="assets/scripts/klorofil-common.js"></script>
        <script src="assets/js/main.js"></script>
    </body>

</html>


