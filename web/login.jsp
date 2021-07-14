
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="assets/css/login.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/styles.css" rel="stylesheet" />
        <title>Login Form</title>
    </head>
    <style>

        #logreg-forms a {
            display: block;
            padding-top: 10px;
            color: white;
        }
    </style>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <div id="logreg-forms">

                <form class="form-signin" action="MainController" method="post">
                    <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Login</h1>
                    <c:if test="${not empty requestScope.error}">
                    <div class="alert alert-danger alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <i class="fa fa-times-circle"></i> ${requestScope.error}
                    </div>
                    </c:if>
                        <input name="txtUsername"  type="text" class="form-control" placeholder="Username" required="" autofocus="" value="${not empty requestScope.id ? requestScope.id : '' }">
                <input name="txtPassword"  type="password"  class="form-control" placeholder="Password" required="">
                <button class="btn btn-success btn-block" type="submit"  name="action" value="Login"><i class="fas fa-sign-in-alt"></i> Login</button>
                <hr>
                <a href="MainController?action=Register" class="btn btn-primary btn-block" type="button" id="btn-signup">Signup to your account</a>
            </form>
            <br>

        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


    </body>
</html>
