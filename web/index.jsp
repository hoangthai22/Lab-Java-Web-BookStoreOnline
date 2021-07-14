<%-- 
    Document   : index
    Created on : Jun 22, 2021, 2:49:56 PM
    Author     : ASUS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Home</title>
        <!-- Favicon-->

        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="assets/css/styles.css" rel="stylesheet" />

    </head>
    <style>

    </style>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <!-- Header-->
            <div class="py-5" style="background-color: #1abc9c !important;">
                <div class="container px-4 px-lg-5 my-5">
                    <div class="text-center text-white"> 
                        <h1 class="display-4 fw-bolder">The Book Store Online</h1>
                        <p class="lead fw-normal text-white-50 mb-0">Tiki Bookstore</p>
                    </div>
                </div>
            </div>
            <!-- Section--> 

            <section class="py-5">
                <div class="container px-4 px-lg-5 mt-5">
                    <div class="row py-5 p-4 bg-white rounded shadow-sm">

                        <form action="MainController" method="post" class="form-inline my-2 my-lg-0" style="">
                            <div class="input-group input-group-sm">
                                <div class="title"><h5>Choose a price range</h5>
                                    <div class="input-group">
                                        <input name="txtPriceStart" type="text" required="" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="0">
                                        <span> &ensp; -  &ensp;</span>
                                        <input name="txtPriceEnd" type="text" required="" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="0">
                                        &ensp;<button style="border-radius: 8px; width: 100px;" type="submit" class="btn btn-secondary btn-number" name="action" value="SearchByPrice">Apply</button>
                                    </div>

                                </div>
                            </div>
                        </form>
                        <br>
                        <br>
                        
                        <div></div>
                    <c:if test="${not empty requestScope.keySearch}">
                        <div class="title"><p style="font-size: 1.5rem;">${requestScope.keySearch} : <span style="color: rgb(137, 137, 137);">${requestScope.bookList.size()} Result</span> </p><br>
                        </c:if>
                        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                            <c:forEach items="${requestScope.bookList}" var="i">
                                <div class="col mb-5">
                                    <a href="MainController?action=DetailBook&id=${i.bookID}" style="color: #343a40">
                                        <div class="card h-100">
                                                   
                                            <img class="card-img-top" src="${i.bookImage}" alt="..." />
                                            <div class="card-body p-4" style="max-block-size: 130px;">
                                                <div class="text-center">
                                                    <h5 class="fw-bolder">${i.bookName}</h5>
                                                    $${i.bookPrice}
                                                </div>
                                            </div>
                                            <!-- Product actions-->
                                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent"> 
                                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="MainController?action=AddToCart&id=${i.bookID}">Add to cart</a></div>
                                            </div>
                                        </div>
                                    </a>
                                </div>

                            </c:forEach>
                            


                            <!-- Product actions-->

                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Footer-->

        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="assets/js/scripts.js"></script>
    </body>
</html>

