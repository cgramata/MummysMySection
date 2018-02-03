<%-- 
    Document   : seeAllOrders
    Created on : Jan 27, 2018, 1:58:32 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>See All Orders</title>
        <style>
             .ordersScreen {
                margin: 0px auto;
                text-align: center;
                font-family: Garmond;
            }
            table {
                border-collapse: collapse;
                width: 90%;
                margin-left: auto;
                margin-right: auto;
            }
            th, td{
                padding: 8px;
                text-align: center;
                border-bottom: 1px solid #ddd;
            }
            tbody tr:hover.selected td,
            tbody tr:hover td {
              background-color: greenyellow;
            }
            tbody tr.selected td {
              background-color: green;
            }
            button input{
                font-size: 10px;
                padding: 5px;
                width: 75%;
            }
        </style>
    </head>
    <body>
        <table>
            <caption class="ordersScreen">Orders</caption>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Customer ID</th>
                    <th>Credit ID</th>
                    <th>Payment Type</th>
                    <th>Total Price</th>
                    <th>Street</th>
                    <th>City</th>
                    <th>Area Code</th>
                    <th>Phone Number</th>
                    <th>Delivery Date</th>
                    <th>Order Date</th>
                    <th>Order Status</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listOfOrders}" var="order">
                    <tr>
                        <td>${order.orderID}</td>
                        <td>${order.customerID}</td>
                        <td>${order.creditID}</td>
                        <td>${order.paymentType}</td>
                        <td>${order.totalPrice}</td>
                        <td>${order.street}</td>
                        <td>${order.city}</td>
                        <td>${order.areaCode}</td>
                        <td>${order.phoneNumber}</td>
                        <td>${order.deliveryDate}</td>
                        <td>${order.orderDate}</td>
                        <td>${order.orderStatus}</td>
                        <td>
                            <a href="editOrder.htm?orderID=${order.orderID}"><button id="editButton">Edit</button></a>
                            <form:form method="POST" action="${userActionUrl}" modelAttribute="orderInfo">
                                <form:input path="orderID" type="hidden" name="orderID" value="${order.orderID}" /> 
                                <input type="submit" value="Delete">
                            </form:form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
