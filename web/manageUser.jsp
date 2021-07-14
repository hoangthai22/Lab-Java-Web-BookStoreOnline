

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!doctype html>
<html>

    <head>
        <title>Manage User</title>
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
                                                        <h2>Manage <b>User</b></h2>
                                                    </div>

                                                </div>
                                            </div>
                                            <table class="table table table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>STT</th>
                                                        <th>UserID</th>
                                                        <th>Full Name</th>
                                                        <th>Phone</th>
                                                        <th>Email</th>
                                                        <th>Status</th



                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${requestScope.listUser}" var="o" varStatus="counter">
                                                        <tr>

                                                            <td>${counter.count}</td>
                                                            <td>${o.userID}</td>
                                                            <td>${o.userFullName}</td>
                                                            <td>${o.userPhone}</td>
                                                            <td>${o.userEmail} </td>
                                                            <input type="hidden" value="${o.userID}" id="idEdit${counter.count}"/>
                                                            <td style="text-align: center"><a style="color: white" class="btn btn-${o.userStatus == 'active' ? 'primary' : 'danger'}">${o.userStatus}</a></td>
                                                            <td>
                                                                <a href="#addEmployeeModal" onclick="CreateDiscount(${counter.count}, ${requestScope.listUser.size()})" style="color: white"  class="btn btn-success" data-toggle="modal"><span>Create New Discount</span></a>
                                                            </td>
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
                            <form action="MainController?action=CreateDiscount" method="post">
                                <div class="modal-header">						
                                    <h4 class="modal-title">Create Discount</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">					
                                    <div class="form-group">
                                        <label>UserID</label>
                                        <input name="txtID" type="text" id="userid" value="" readonly="" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Discount Code</label>
                                        <input name="txtDiscountCode" type="text"value="" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Discount Name</label>
                                        <input name="txtDiscountName" type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Discount Percent</label>
                                        <input name="txtDiscountPercent" type="number" class="form-control" required>
                                    </div>
                                   
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                    <input type="submit" class="btn btn-success" value="Create">
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
       
       
        <script>
            function CreateDiscount(index, total) {
                console.log(total);
                for (var i = 0; i < total + 1; i++) {
                    if (index === i) {
                        
                        var idEdit = document.getElementById("idEdit" + i).value;
                        console.log(idEdit);
                        document.getElementById("userid").setAttribute("value", idEdit);
                    }
                }
            }
        </script>
    </body>

</html>


