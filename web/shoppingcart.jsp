

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="assets/css/styles.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"> 
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

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
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="p-2 px-3 text-uppercase">Product</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Price</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Quantity</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Remove</div>
                                                    </th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <c:forEach items="${sessionScope.cart.cart}" var="o">
                                                    <tr>
                                                        <th scope="row">
                                                            <a href="MainController?action=DetailBook&id=${o.value.bookID}">
                                                                <div class="p-2">
                                                                    <img src="${o.value.bookImage}" alt="" width="70" class="img-fluid rounded shadow-sm"/>
                                                                    <div class="ml-3 d-inline-block align-middle">
                                                                        <h5 class="mb-0"> <p class="text-dark d-inline-block">${o.value.bookName}</p></h5><span class="text-muted font-weight-normal font-italic"></span>
                                                                    </div>
                                                                </div>
                                                            </a>
                                                        </th>
                                                        <td class="align-middle"><strong>$${o.value.bookPrice}</strong></td>
                                                        <td class="align-middle">
                                                            <div  style="width: 80px;">
                                                                <input type="hidden" name="listID" value="${o.value.bookID}"/>
                                                                <input type="number"  required="" name="txtQuantity" ${o.value.bookError ? 'style="background-color: pink"' : ''} value="${o.value.bookQuantity}" aria-describedby="button-addon3" class="form-control border-0"/>
                                                            </div>
                                                            </strong>
                                                        </td>

                                                        <td class="align-middle"><a href="#" class="text-dark">
                                                                <a href="MainController?action=DeleteCart&id=${o.value.bookID}" onclick="Confirm()" type="button" class="btn btn-danger rounded-pill">Delete</a>
                                                            </a>
                                                        </td>
                                                    </tr> 

                                                </c:forEach>

                                            </tbody>

                                        </table>
                                        <button type="submit" class="btn btn-warning rounded-pill" style="float: right; margin-right: 80px">Update</button>
                                    </form>
                                </div>
                                <!-- End -->
                            </div>
                        </div>
                        <form action="MainController" method="post">
                            <div class="row py-5 p-4 bg-white rounded shadow-sm">

                                <div class="col-lg-6">
                                    <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Infomation</div>
                                    <div class="p-4"> 
                                        <div class="input-group mb-4 border rounded-pill p-2">
                                            <input type="text" placeholder="Enter your name" name="txtNameOrder" value="${sessionScope.user.userFullName}" aria-describedby="button-addon3" class="form-control border-0"/>

                                        </div>
                                        <div class="input-group mb-4 border rounded-pill p-2">
                                            <input type="text" placeholder="Enter your delivery address"  name="txtAdress" value="${sessionScope.user.userAddress}" aria-describedby="button-addon3" class="form-control border-0"/>

                                        </div>
                                        <div class="input-group mb-4 border rounded-pill p-2">
                                            <input type="number" placeholder="Enter your phone number"  name="txtPhone" value="${sessionScope.user.userPhone}" aria-describedby="button-addon3" class="form-control border-0"/>

                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-6">
                                    <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Bill</div>
                                    <div class="p-4">
                                        <ul class="list-unstyled mb-4">
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Price</strong>
                                                <strong>
                                                    <c:if test="${not empty sessionScope.cart.discount}">
                                                        <span class="text-muted text-decoration-line-through">${sessionScope.cart.getTotalPriceByDiscount(0)} $</span>
                                                        ${sessionScope.cart.getTotalPriceByDiscount(0) - sessionScope.cart.getTotalPriceByDiscount(sessionScope.cart.discount.discountPercent)} $
                                                    </c:if> 
                                                    <c:if test="${sessionScope.cart.discount == null}">
                                                        ${sessionScope.cart.getTotalPriceByDiscount(0)}
                                                    </c:if>
                                                </strong></li>
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Shipping fee</strong><strong>3 $</strong></li>
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tax</strong><strong>2 $</strong></li>
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Discount</strong><strong>-  $${sessionScope.cart.discount == null ? '0' : sessionScope.cart.getTotalPriceByDiscount(sessionScope.cart.discount.discountPercent) }</strong></li>
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total</strong>
                                                <h5 class="font-weight-bold">

                                                    ${sessionScope.cart.getTotalPrice()} $</h5>
                                            </li><br>
                                            <c:if test="${not empty sessionScope.cart.discount}">
                                                <li class="d-flex justify-content-between py-3 border-bottom">
                                                    <div class="input-group-append border-0">
                                                        <p style="width: 452px;"  name="action" value="Apply" class="btn btn-info rounded-pill"><i class="fa fa-gift mr-2"></i><span style="margin-right: 150px">${sessionScope.cart.discount.discountName}</span>
                                                            <a href="MainController?action=RemoveDiscount&txtDiscount=${sessionScope.cart.discount.discountID}" id="remove" style="margin-right: -176px" >
                                                                <i style="color: white" class="fa fa-remove mr-2 "></i>
                                                            </a>
                                                        </p>
                                                    </div>
                                                </li>
                                            </c:if>
                                            <c:if test="${not empty requestScope.error}">
                                                <div class="alert alert-danger alert-dismissible" role="alert">
                                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                                    <i class="fa fa-times-circle"></i> ${requestScope.error}
                                                </div>
                                            </c:if>
                                            <form action="MainController" method="post">

                                                <div class="input-group mb-4 border rounded-pill p-2">
                                                    <input type="text" name="txtDiscount" value=""  placeholder="Nhập Voucher" aria-describedby="button-addon3" class="form-control border-0"/>
                                                    <div class="input-group-append border-0">
                                                        <button  name="action" value="Apply" class="btn btn-dark px-4 rounded-pill"><i class="fa fa-gift mr-2"></i>Apply</button>
                                                    </div>
                                                </div>
                                            </form>
                                            <strong class="text-muted">Payments:</strong> &nbsp;&nbsp;
                                            <input type="radio" name="checkout" value="PaymentDelivery" checked=""> &nbsp; Payment on delivery
                                            &nbsp;&nbsp;
                                            <input type="radio" name="checkout" value="PaymentOnline"> &nbsp;Online payment
                                        </ul><button href="buy" name="action" value="Buy" class="btn btn-dark rounded-pill py-2 btn-block" onclick="Confirm()" >Check out</button>
                                    </div>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
                                            function Confirm() {
                                                //var result = Confirm("Do you want to delete");
                                                var result = confirm("Are you sure you want to do this ?");
                                                if (!result) {
                                                    event.preventDefault();
                                                }
                                            }</script>

    </body>

</html>
</html>
