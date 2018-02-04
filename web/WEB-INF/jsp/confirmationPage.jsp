<%-- 
    Document   : confirmationPage
    Created on : Jan 30, 2018, 3:48:00 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
        <style>
            table {
                
                width: 50%;
                margin-left: auto;
                margin-right: auto;
                text-align: center;
            }
        </style>
    </head>
    <body>
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
                <c:forEach items="${pkgOrderInfo}" var="pkg">
                    <tr>
                        <td>${pkg.pName}</td>
                        <td>${pkg.oQuantity}</td>
                        <td>${pkg.oPricePerPkg}</td>
                    </tr>
                </c:forEach>
                    <tr>
                        <td>Total Price:$ ${finalPrice}</td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Continue with the purchase?</td>
                    </tr>
                    <tr>
                        <td>
                            <a href="enterFinalOrderInfo.htm"><button id="toOrderInfo">Enter Address</button></a>
                        </td>
                        <td>
                            <a href="menu.htm"><button>Cancel</button></a>
                        </td>    
                    </tr>
            </tbody>
            <p></p>
        </table>
    </body>
</html>
