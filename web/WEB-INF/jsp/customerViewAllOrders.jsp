<%-- 
    Document   : customerViewAllOrders
    Created on : Feb 5, 2018, 5:56:17 PM
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
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #006400;
            }

            li {
                float: left;
            }

            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover {
                background-color: #ADFF2F;
                color: #006400;

            }
            li a:active {
                background-color: #ADFF2F;
                color: #006400;
            }
            .banner-img{
                /* The image used */
                background-image: url('images/buffet.png');

               /*  Set a specific height */
                height: 100px;

                /* Position and center the image to scale nicely on all screens */
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
                position: relative;
            }
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
        <div class="banner-img"></div>
        <nav>
            <ul>
                <li><a href="customerhome.htm">Home</a></li>
                <li><a href="menu.htm">Menu</a></li>
                <li><a href="#contact">Contact</a></li>
                <li><a href="#about">About</a></li> 
            </ul>
        </nav><br>
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
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
