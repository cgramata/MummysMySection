<%-- 
    Document   : editOrder
    Created on : Jan 30, 2018, 12:50:09 AM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Existing Order</title>
    </head>
    <body>
        <form:form method="POST" action="${userActionUrl}" modelAttribute="orderInfo">
            <table>
                <tr>
                    <td>Order ID: = ${orderDetail.orderID}</td>
                </tr>
                <tr>
                    <td>Customer ID: </td>
                    <td><form:input path="customerID" type="text" name="customerID" value="${orderDetail.customerID}" /></td>
                </tr>
                <tr>
                    <td>Credit ID: </td>
                    <td><form:input path="creditID" type="text" name="creditID" value="${orderDetail.creditID}" /></td>
                </tr>
                <tr>
                    <td>Payment Type:  </td>
                    <td><form:input path="paymentType" type="text" name="paymentType" value="${orderDetail.paymentType}" /></td>
                </tr>
                <tr>
                    <td>Total Price:  </td>
                    <td><form:input path="totalPrice" type="text" name="totalPrice" value="${orderDetail.totalPrice}" /></td>
                </tr>
                <tr>
                    <td>Street: </td>
                    <td><form:input path="street" type="text" name="street" value="${orderDetail.street}" /></td>
                </tr>
                <tr>
                    <td>City:  </td>
                    <td><form:input path="city" type="text" name="city" value="${orderDetail.city}" /></td>
                </tr>
                <tr>
                    <td>Area Code:  </td>
                    <td><form:input path="areaCode" type="text" name="areaCode" value="${orderDetail.areaCode}" /></td>
                </tr>
                <tr>
                    <td>Phone Number:  </td>
                    <td><form:input path="phoneNumber" type="text" name="phoneNumber" value="${orderDetail.phoneNumber}" /></td>
                </tr>
                <tr>
                    <td>Delivery Date:  </td>
                    <td><form:input path="deliveryDate" type="text" name="deliveryDate" value="${orderDetail.deliveryDate}" /></td>
                </tr>
                <tr>
                    <td>Order Date:  </td>
                    <td><form:input path="orderDate" type="text" name="orderDate" value="${orderDetail.orderDate}" /></td>
                </tr>
                <tr>
                    <td>Order Status:  </td>
                    <td><form:input path="orderStatus" type="text" name="orderStatus" value="${orderDetail.orderStatus}"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Update"></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
