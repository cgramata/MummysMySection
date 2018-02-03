<%-- 
    Document   : enterFinalOrderInfo
    Created on : Jan 31, 2018, 6:19:54 AM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter Delivery Address</title>
    </head>
    <body>
        <form:form method="POST" action="${userActionUrl}" modelAttribute="newOrderInfo">
            <table>
                <tr>
                    <td>Street: </td>
                    <td><form:input path="street" /></td>
                </tr>
                <tr>
                    <td>City:  </td>
                    <td><form:input path="city" /></td>
                </tr>
                <tr>
                    <td>Area Code:  </td>
                    <td><form:input path="areaCode" /></td>
                </tr>
                <tr>
                    <td>Phone Number:  </td>
                    <td><form:input path="phoneNumber" /></td>
                </tr>
                <tr>
                    <td>Delivery Date:  </td>
                    <td><form:input path="deliveryDate" /></td>
                </tr>
                <tr>
                    <td>Order Date:  </td>
                    <td><form:input path="orderDate" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Submit"></td>
                    <td><input id="backToConfirm" type="button" onclick="window.location 
                                = 'confirmationPage.htm'" value ="Back to Confirmation"></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
