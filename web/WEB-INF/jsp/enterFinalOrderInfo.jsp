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
            <div class="banner-img"></div>
            <nav>
                <ul>
                    <li><a href="#home">Home</a></li>
                    <li><a href="menu.htm">Menu</a></li>
                    <li><a href="#contact">Contact</a></li>
                    <li><a href="#about">About</a></li> 
                </ul>
            </nav><br>
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
            </form:form>
        </div>
    </body>
</html>
