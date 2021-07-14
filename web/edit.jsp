
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

    <head>
        <title>Edit Book</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
        <!-- VENDOR CSS -->
        <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/vendor/linearicons/style.css">
        <!-- MAIN CSS -->
        <link rel="stylesheet" href="assets/css/main.css">
        <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
        <link rel="stylesheet" href="assets/css/demo.css">
        <!-- GOOGLE FONTS -->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
        <!-- ICONS -->
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
    </head>
    <style>
        #testForm label.error{
            color: red;
            width: 250px;
            font-style: italic;
        }</style>
    <body>
        <!-- WRAPPER -->
        <div id="wrapper">
            <jsp:include page="menuAdmin.jsp"></jsp:include>


                <div class="main">
                    <!-- MAIN CONTENT -->
                    <div class="main-content">
                        <div class="container-fluid">

                            <div class="row">
                                <div class="col-md-8">
                                    <!-- PANEL HEADLINE -->
                                    <div class="panel panel-headline">
                                    <c:if test="${not empty requestScope.error}">
                                        <div class="alert alert-danger alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                            <i class="fa fa-times-circle"></i> ${requestScope.error}
                                        </div>
                                    </c:if>
                                    <form action="MainController?action=EditBook" method="post" id="testForm"
                                          enctype="multipart/form-data">
                                        <div class="profile-main" style="margin-top: 10px;margin-left: 27px;">
                                            <img src="${requestScope.book.bookImage}" class="img-circle" alt="Avatar" style="width: 15%;border-radius: 0px">
                                            <input type="hidden" name="txtImgOld" value="${requestScope.book.bookImage}"/>

                                        </div>
                                        <div class="panel-body">
                                            <h3 class="page-title"><label class="control-label">Book Detail</label></h3>
                                            <label class="control-label">ID </label>
                                            <input class="form-control input-lg" type="text" required="" name="txtID" value="${requestScope.book.bookID}" readonly="">
                                            <br> 
                                            <label class="control-label">Title </label>
                                            <input class="form-control input-lg" type="text" required="" name="txtName" value="${requestScope.book.bookName}">
                                            <br>
                                            <label class="control-label">Author </label>
                                            <input class="form-control input-lg" type="text" required="" name="txtAuthor" value="${requestScope.book.bookAuthor}">
                                            <br>
                                            <label class="control-label">Price </label>
                                            <input class="form-control input-lg" type="number" required=""  name="txtPrice" value="${requestScope.book.bookPrice}">
                                            <br>
                                            <label class="control-label">Quantity </label>
                                            <input class="form-control input-lg" type="number" required="" name="txtQuantity" value="${requestScope.book.bookQuantity}">
                                            <br>
                                            <label class="control-label">Import date </label>
                                            <input type="date" class="form-control" name="txtDate" required="" value="${requestScope.book.bookCreateDate}">
                                            <br>
                                            <label class="control-label">Description </label>
                                            <textarea name="txtDescription" class="form-control" required="">${requestScope.book.bookDescription}
                                              
                                            </textarea>
                                            <br>
                                            <label class="control-label">Category </label>
                                            <select class="form-control" style="height: 46px" name="txtCategory">
                                                <c:forEach items="${requestScope.categoryList}" var="i">
                                                    <option ${requestScope.book.categoryID == i.categoryName ? 'selected=""' : ''} value="${i.categoryID}">${i.categoryName}</option>
                                                </c:forEach>
                                            </select>

                                            <br>
                                            <span>Image: </span>
                                            <input type="file" name = "fileup"  value="${requestScope.listUser.userImg} style="width: 100%;"/>
                                            <br>
                                            <input type="submit" value="Edit" name="action" class="btn btn-warning" style="margin-left: 900px; width: 100px; height: 40px;"/>

                                        </div>
                                    </form>


                                </div>
                                <!-- END PANEL HEADLINE -->
                            </div>

                        </div>


                    </div>
                </div>
                <!-- END MAIN CONTENT -->
            </div>
            <!-- END MAIN -->
            <div class="clearfix"></div>
            <footer>
                <div class="container-fluid">
                    <p class="copyright">&copy; 2017 <a href="https://www.themeineed.com" target="_blank">Theme I Need</a>. All Rights Reserved.</p>
                </div>
            </footer>
        </div>
        <!-- END WRAPPER -->
        <!-- Javascript -->
        <script src="assets/js/jquery-3.2.1.js"></script>
        <script src="assets/js/jquery.validate.js"></script>
        <script src="assets/js/additional-methods.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
        <script src="assets/scripts/klorofil-common.js"></script>
        <script type="text/javascript">
            $(function () {
                $("#testForm").validate({
                    rules: {
                        txtName: {
                            required: true,
                            rangelength: [1, 50]
                        },
                        txtAuthor: {
                            required: true,
                            rangelength: [1, 50]
                        },
                        txtPrice: {
                            required: true,
                            rangelength: [1, 50]
                        },
                        txtQuantity: {
                            required: true,
                           
                        },
                        txtDate: {

                            required: true
                        },
                        txtDescription: {

                            required: true
                        },
                        txtCategory: {

                            required: true
                        }

                    }
                });
            });
        </script>
    </body>

</html>
