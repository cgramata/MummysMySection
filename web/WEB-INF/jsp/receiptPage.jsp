<%-- 
    Document   : receiptPage
    Created on : Jan 30, 2018, 3:48:21 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Receipt Page</title>
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
            #orderInfoTable {
                width: 100%;
                border-collapse: collapse;
                margin-left: auto;
                margin-right: auto;
                text-align: center;
            }
            #logisticsInfoTable{
                width: 100%;
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
            #finalPriceAddressDiv {
                text-align: center;
                width: 50%;
                height: 120px;
                text-align: center;
                padding: 30px 0 0 20px;
                margin-top: 20px;
                border: solid 2px #000;
            }
            #enterYourAddressDiv{
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
        <h1>Thank you for your order!</h1>
        <div id="center">
            <table id="orderInfoTable">
                <caption class="pkgOrderView"><h3>Complete Your Order :)</h3></caption>
                <thead class="inTableHead">
                    <tr>
                        <th class="inTableHead">Item Name</th>
                        <th class="inTableHead">Quantity</th>
                        <th class="inTableHead">Price Per Unit</th>
                    </tr>
                </thead>
                <tbody class="inTable">
                    <c:forEach items="${itemsOrdered}" var="pkg">
                        <tr>
                            <td class="inTable">${pkg.pName}</td>
                            <td class="inTable">${pkg.oQuantity}</td>
                            <td class="inTable">$${pkg.oPricePerPkg}</td>
                        </tr>
                    </c:forEach>
                    <tr>

                    </tr>
                </tbody>
            </table>
        </div>
        <div id="finalPriceAddressDiv">
            <table id="logisticsInfoTable">
                <tr>
                    <th>Final price: </th>
                    <th>Deliver to: </th>
                    <th>To be delivered on: </th>
                </tr>
                <tr>
                    <td>${finalPrice}</td>
                    <td>${orderDetails.street}</td>
                    <td>${orderDetails.deliveryDate}</td>
                </tr>
                <tr>
                    <td></td>
                    <td>${orderDetails.city}</td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td>${orderDetails.areaCode}</td>
                    <td></td>
                </tr>
            </table>
        </div>
    </body>
</html>
