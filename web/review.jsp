<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Review</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/review.css">
        <style type="text/css">
            table { border: 0; }
            table td { padding: 5px; }
            #Checkout>form{
                margin-left: 85px;
            }
        </style>
    </head>


    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <br>
        <div class="container">
            <div id="Checkout" class="inline">
                <h1>Pay Invoice</h1>
                <div class="card-row">
                    <span class="visa"></span>
                    <span class="mastercard"></span>
                    <span class="amex"></span>
                    <span class="discover"></span>
                </div>
                <form action="MainController?action=Pay" method="post">
                    <div class="form-group">
                        <td colspan="2"><b>Payment amount:</b></td>
                        <div class="amount-placeholder">
                            <span>$</span>
                            <span>${transaction.amount.total}</span>
                        </div>
                    </div>

                    
                        <table>
                            <tr>
                                <td colspan="2"><b>Transaction Details:</b></td>
                                <td>
                                    <input type="hidden" name="paymentId" value="${param.paymentId}" />
                                    <input type="hidden" name="PayerID" value="${param.PayerID}" />
                                </td>
                            </tr>
                            <tr>
                                <td>Order ID:</td>
                                <td>${transaction.description}</td>
                            </tr>
                            <tr>
                                <td>Subtotal:</td>
                                <td>${transaction.amount.details.subtotal} $</td>
                            </tr>
                            <tr>
                                <td>Shipping:</td>
                                <td>${transaction.amount.details.shipping} $</td>
                            </tr>
                            <tr>
                                <td>Tax:</td>
                                <td>${transaction.amount.details.tax} $</td>
                            </tr>
                            <tr>
                                <td>Discount: </td>
                                <td>${transaction.amount.details.shippingDiscount} $</td>
                            </tr>
                            <tr>
                                <td>Total:</td>
                                <td>${transaction.amount.total} $</td>
                            </tr>
                            <tr><td><br/></td></tr>
                            <tr>
                                <td colspan="2"><b>Payer Information:</b></td>
                            </tr>
                            <tr>
                                <td>First Name:</td>
                                <td>${payer.firstName}</td>
                            </tr>
                            <tr>
                                <td>Last Name:</td>
                                <td>${payer.lastName}</td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td>${payer.email}</td>
                            </tr>
                            <tr><td><br/></td></tr>
                            <tr>
                                <td colspan="2"><b>Shipping Address:</b></td>
                            </tr>
                            <tr>
                                <td>Recipient Name:</td>
                                <td>${sessionScope.user.userID}</td>
                            </tr>
                            <tr>
                                <td>Address:</td>
                                <td>${sessionScope.user.userAddress}</td>
                            <input type="hidden" name="txtAdress" value="${sessionScope.user.userAddress}"/>
                            </tr>
                            <tr>
                                <td>Phone:</td>
                                <td>${sessionScope.user.userPhone}</td>
                            <input type="hidden" name="txtPhone" value="${sessionScope.user.userPhone}"/>
                            </tr>
                        </table>
                            <br>
                            <button style="margin-left: -25px;"  id="PayButton" class="btn btn-block btn-success submit-button" type="submit">
                                <input type="hidden" name="checkout" value="PaymentOnline"/>
                            <span class="submit-button-lock"></span>
                            <span class="align-middle">Pay </span>
                        </button>
                    </form>
            </div>
        </div>
    </body>
</html>