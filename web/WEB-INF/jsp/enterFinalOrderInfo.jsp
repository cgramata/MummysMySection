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
        <style>
            h1 {
                text-align: center;
            }
            #center {
                text-align: center;
            }
            table {
                width: 90%;
                border-collapse: collapse;
                margin-left: auto;
                margin-right: auto;
                text-align: center;
            }
            .inputFieldRow {
                padding: 0 0 10px 0;
            }
            #totalPriceDiv {
                float: left;
                width: 50%;
                height: 50px;
                text-align: center;
            }
            #enterYourAddressDiv{
                float: right;
                width: 50%;
                height: 50px;
                text-align: center;
            }
        </style>
    </head>
    <body
        <div id="center">
            <h1>Please enter the delivery address</h1>
            <form:form method="POST" action="${userActionUrl}" modelAttribute="newOrderInfo">
                <table>
                    <tr>
                        <td class="texts">Street: </td>
                        <td class="texts">City: </td>
                    </tr>
                    <tr>
                        <td class="inputFieldRow"><form:input path="street" /></td>
                        <td class="inputFieldRow"><form:input path="city" /></td>
                    </tr>
                    <tr>
                        <td class="texts">Area Code:  </td>
                        <td class="texts">Phone Number:  </td>
                    </tr>
                    <tr>
                        <td class="inputFieldRow"><form:input path="areaCode" /></td>
                        <td class="inputFieldRow"><form:input path="phoneNumber" /></td>
                    </tr>
                    <tr>
                        <td class="texts">Delivery Date:  </td>
                    </tr>
                    <tr>
                        <td class="inputFieldRow"><form:input path="deliveryDate" /></td>
                    </tr>
                </table>
            </form:form>
        </div>
        <div id="submitOrderDiv">
            <h4>Submit your order!</h4>
            <table>
                <tr>
                    <td colspan="2"><input type="submit" value="Submit"></td>
                </tr>
                <tr>
                    <td><input id="backToConfirm" type="button" onclick="window.location
                                    = 'confirmationPage.htm'" value ="Back to Confirmation"></td>
                </tr>
        </div>
    </body>
</html>
