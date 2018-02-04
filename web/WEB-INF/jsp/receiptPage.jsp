<%-- 
    Document   : receiptPage
    Created on : Jan 30, 2018, 3:48:21 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Receipt Page</title>
    </head>
    <body>
        <h2>Thank you for your order!</h2>
        <table>
            <caption class="pkgOrderView"><h3>Complete Your Order :)</h3></caption>
            <thead>
                <tr>
                    <th>Package Name</th>
                    <th>Quantity</th>
                    <th>Price Per Pack</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${itemsOrdered}" var="pkg">
                    <tr>
                        <td>${pkg.pName}</td>
                        <td>${pkg.oQuantity}</td>
                        <td>${pkg.oPricePerPkg}</td>
                    </tr>
                </c:forEach>
                    <tr>
                        <td>Total Price:$ ${finalPrice}</td>
                    </tr>
            </tbody>
        </table>
</html>
