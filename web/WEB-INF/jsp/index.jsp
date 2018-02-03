<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int paymentType = 2;
    int creditID = 1;
    int customerID = 2;
    int orderID = 9;
    session.setAttribute("orderID",orderID);
    session.setAttribute("paymentType", paymentType);
    session.setAttribute("creditID", creditID);
    session.setAttribute("customerID", customerID);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mummys Restaurant Testing Index Page</title>
    </head>

    <body>
        
        <p><a href="seeAllOrders.htm">See All Orders</a></p>
        <p><a href="newOrders.htm">Insert New Order</a></p>
        <p><a href="choosePaymentOption.htm">Choose Payment</a></p>
    </body>
</html>
