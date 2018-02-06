<%-- 
    Document   : choosePaymentOption
    Created on : Jan 30, 2018, 3:47:31 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choose Payment</title>
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
            .inTableHead {
                padding: 8px;
                border-bottom: 2px solid #000; 
            }
            .inTable {
                padding: 8px;
                border-bottom: 1px solid #ddd;
            }
            #addMoreDiv {
                float: left;
                width: 50%;
                height: 50px;
                text-align: center;
            }
            #choosePaymentDiv{
                float: right;
                width: 50%;
                height: 50px;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="banner-img"></div>
        <nav>
            <ul>
                <li><a href="#home">Home</a></li>
                <li><a href="menu.htm">Menu</a></li>
                <li><a href="#contact">Contact</a></li>
                <li><a href="#about">About</a></li> 
            </ul>
        </nav><br>
        <h1>Your order so far...</h1>
        <div id="center">
            <table>
                <thead>
                    <tr>
                        <th class="inTableHead">Item Name</th>
                        <th class="inTableHead">Quantity</th>
                        <th class="inTableHead">Price Per Unit</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pkgOrderInfo}" var="pkg">
                        <tr>
                            <td class="inTable">${pkg.pName}</td>
                            <td class="inTable">${pkg.oQuantity}</td>
                            <td class="inTable">$${pkg.oPricePerPkg}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div id="addMoreDiv">
            <h4>Add more to your cart?</h4>
            <table>
                <tr>
                    <td>
                        <a href="menu.htm"><button id="toMenu">Menu</button></a>
                    </td>
                </tr>
            </table>
        </div>
        <div id="choosePaymentDiv">
            <h4>Choose your payment option</h4>
            <table>
                <tr>
                    <td>
                        <a href="confirmationPage.htm"><button id="toConfirmation">Cash</button></a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="CreditCardUserUI.htm"><button id="toCreditCard">Credit</button></a>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
