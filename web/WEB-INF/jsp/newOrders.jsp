<%-- 
    Document   : newOrder
    Created on : Jan 27, 2018, 1:59:00 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert New Order</title>
    </head>
    <body>
        <form:form method="POST" commandName="newOrders">
            <table>
                <tr>
                    <td>Order ID: </td>
                    <td><form:input path="orderID" /></td>
                </tr>
                <tr>
                    <td>Customer ID: </td>
                    <td><form:input path="customerID" /></td>
                </tr>
                <tr>
                    <td>Credit ID: </td>
                    <td><form:input path="creditID" /></td>
                </tr>
                <tr>
                    <td>Payment Type:  </td>
                    <td><form:input path="paymentType" /></td>
                </tr>
                <tr>
                    <td>Total Price:  </td>
                    <td><form:input path="totalPrice" /></td>
                </tr>
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
                    <td>Order Status:  </td>
                    <td><form:input path="orderStatus" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Submit"></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
