<%-- 
    Document   : loginsuccess
    Created on : May 14, 2021, 11:43:00 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Login - Bootstrap Admin Template</title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0,
              maximum-scale=1.0, user-scalable=no">
        <meta name="apple-mobile-web-app-capable" content="yes">

        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"
              />

        <link href="css/font-awesome.css" rel="stylesheet">
        <link
            href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
            rel="stylesheet">

        <link href="assets/css/style.css" rel="stylesheet" type="text/css">
        <link href="assets/css/signin.css" rel="stylesheet" type="text/css">

    </head>
    <style>

    </style>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <div class="account-container register">
                <div class="content clearfix">
                    <form action="MainController" method="post" class="form-signin">
                        <h2 style="text-align: center; font-size: 25px;">OTP Verification</h2>
                        <div class="login-fields">
                            <div><h5 style="font-size: 20px;">We've sent a verification code to your email - ${requestScope.Email} - Please check your email</h5> <br></div>
                            <c:if test="${not empty requestScope.Error}">
                            <div class="alert alert-danger alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                <i class="fa fa-times-circle"></i> ${requestScope.Error}
                            </div>
                        </c:if>
                       
                        <div class="item">
                            <p>The OTP code will expire in: <span id="seconds">60</span>s </p>

                        </div>

                        <div class="field">

                            <input type="text" name="txtVerification" value=""
                                   placeholder="Enter verification code" class="form-control" />
                        </div> <!-- /field -->

                    </div> <!-- /login-fields -->
                    <div class="login-actions" > 

                        <input type="submit" id="verify" name="action" value="Verify"  class="button btn btn-primary btn-large" >
                    </div> <!-- .actions -->

                </form>

            </div> <!-- /content -->

        </div> <!-- /account-container -->


        <div class="login-extra">
            Don't have an account? <a href="register.jsp">Signup to your account</a>
        </div> <!-- /login-extra -->


        <script src="js/jquery-1.7.2.min.js"></script>
        <script src="js/bootstrap.js"></script>

        <script src="js/signin.js"></script>

    </body>
    <script>
         var time = 60;
         var myVar = setInterval(function () {
         var noW = time--;
         
         if (noW > -1) {
         document.getElementById("seconds").innerText = noW;
         } else {
         var html = document.getElementById("verify");
         
         html.setAttribute("disabled","true");
         console.log(html);
         clearInterval(myVar);
         }
         }, 1000);
         
    </script>
</html>


