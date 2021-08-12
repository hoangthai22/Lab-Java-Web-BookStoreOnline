<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="assets/css/login.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/styles.css" rel="stylesheet" />
        <title>Register Form</title>
    </head>
    
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
      
        <div id="logreg-forms">

            <form class="form-signin" action="MainController"  method="post">
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign up</h1>
                <c:if test="${not empty requestScope.error}">
                    <div class="alert alert-danger alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <i class="fa fa-times-circle"></i> ${requestScope.error}
                    </div>
                </c:if>
                <input name="txtUserID" type="text" class="form-control" placeholder="Email" required="" autofocus="">
                <input name="txtPassword" type="password" class="form-control" placeholder="Password" required autofocus="">
                <input name="txtConfirmPassword" type="password"  class="form-control" placeholder="Confirm password" required autofocus="">
                <input name="txtFullname" type="text" class="form-control" placeholder="Full name" required="" autofocus="">
                <input name="txtPhone" type="text" class="form-control" placeholder="Phone number" required="" autofocus="">
                <input name="txtAddress" type="text" class="form-control" placeholder="Address" required="" autofocus="">
                <font color ="red">
               
                </font>
                <button class="btn btn-primary btn-block" type="submit" name="action" value="Signup"><i class="fas fa-user-plus"></i>Đăng kí</button>
                <a href="MainController?action=LoginPage" >  Trở về</a>

            </form>

            <br>

        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        
       
    </body>
</html>

