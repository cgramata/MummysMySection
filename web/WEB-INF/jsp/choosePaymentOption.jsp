<%-- 
    Document   : choosePaymentOption
    Created on : Jan 30, 2018, 3:47:31 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choose Payment</title>
    </head>
    <body>
        <table>
            <caption class="pkgOrderView">Packages In Order</caption>
            <thead>
                <tr>
                    <th>Package Name</th>
                    <th>Quantity</th>
                    <th>Price Per Pack</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${pkgOrderInfo}" var="pkg">
                    <tr>
                        <td>${pkg.pName}</td>
                        <td>${pkg.oQuantity}</td>
                        <td>${pkg.oPricePerPkg}</td>
                    </tr>
                </c:forEach>
                    <tr>
                        <td>Please Choose Your Payment:</td>
                    </tr>
                    <tr>
                        <td>
                            <a href="CreditCardUserUI.htm"><button id="toCreditCard">Credit</button></a>
                        </td>
                        <td>
                            <a href="confirmationPage.htm"><button id="toConfirmation">Cash</button></a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="menu.htm"><button id="toMenu">Menu</button></a>
                        </td>
                    </tr>
            </tbody>
        </table>
    </body>
</html>
