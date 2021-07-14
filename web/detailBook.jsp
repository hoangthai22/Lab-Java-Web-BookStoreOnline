
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />

        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="assets/css/styles.css" rel="stylesheet" />
        <title>Detail Book</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <!-- Product section-->
            <section class="py-5">
                <div class="container px-4 px-lg-5 my-5">
                    <div class="row gx-4 gx-lg-5 align-items-center">
                        <div class="col-md-6"><img
                                class="card-img-top mb-5 mb-md-0" src="${requestScope.bookDetail.bookImage}" alt="..." /></div>
                    <div class="col-md-6">
                        <div class="small mb-1" style="font-size: 1rem;">Author: ${requestScope.bookDetail.bookAuthor}</div>
                        <h2 style="font-size: 2rem;"class="display-5 fw-bolder">${requestScope.bookDetail.bookName}</h2>
                        <br>
                        <div class="fs-5 mb-5">
                            <!--<span class="text-decoration-line-through">$45.00</span>-->
                            <span style="font-size: 2rem;">$${requestScope.bookDetail.bookPrice}0</span>
                        </div>
                        <div class="fs-5 mb-5">
                            <h4>Category: </h4><p class="lead">${requestScope.bookDetail.categoryID}</p>
                        </div>
                        <div class="fs-5 mb-5">
                            <h4>Import date: </h4><p class="lead">${requestScope.bookDetail.bookCreateDate}</p>
                        </div>
                        <c:if test="${not empty requestScope.errorQuantity}">
                            <div class="alert alert-danger alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                <i class="fa fa-times-circle"></i> ${requestScope.errorQuantity}
                            </div>
                        </c:if>
                        <form action="MainController" method="post">
                            <div class="d-flex">
                                <input type="hidden" name="id" value="${requestScope.bookDetail.bookID}"/>
                                <input class="form-control text-center me-3" type="text" name="quantityCart" value="1" style="max-width: 3rem" />
                                <button class="btn btn-outline-dark flex-shrink-0"  name="action" value="AddToCartFromDetail">
                                    <i class="bi-cart-fill me-1"></i>
                                    Add to cart
                                </button>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div>
                <div class="container px-4 px-lg-5 my-5">
                    <div class="col-md-12">
                        <h4>Book Description: </h4>
                        <p class="lead">${requestScope.bookDetail.bookDescription}</p>
                    </div>
                </div>
            </div>
        </section>
        <!-- Related items section-->


        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="assets/js/scripts.js"></script>
    </body>
</html>

