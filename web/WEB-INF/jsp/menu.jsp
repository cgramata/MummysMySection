<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="react.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.29/browser.js"></script>
        <link href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.min.css" rel="stylesheet" type="text/css" />
        <script src="https://code.jquery.com/jquery.min.js"></script>
        <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

        <title>Menu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <script>
            $(document).ready(function() {
                $('tr').click(function() {
                    var href = $(this).find("td").attr("href");
                    var package = $(this).find("td").attr("package");
                    if(href) {
                        window.location = href+"?packageId="+package;
                    }
                });
            });
        </script>
        <style>
            .menuTitle {
                text-align: center;
                font-family: Garmond;
                font-size: 2em;
            }
            table,tr,th,td{
                border: 1px solid black;
                font-family: Garmond;
                font-size: 1.1em;
                padding: 5px;
            }

            table {
                border-collapse: collapse;
                font-family: Garmond;
                width: 90%;
                margin: auto;
            }
            .packageImage{
                width: 10em;
            }
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
            .button {
                font-family: Garmond;
                font-size: 1.1em;
            }
            tbody tr:hover.selected td,
            tbody tr:hover td {
              background-color: greenyellow;
              cursor: pointer;
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
        <input class="button" id="cartBtn" type="button"  onclick="window.location = 'cart.htm'" value="View Cart" >
        <input class="button" id="checkoutBtn" type="button"  onclick="window.location = 'choosePaymentOption.htm'" value="Go To Checkout" >
        <table id="packageTable">
            <caption class="menuTitle">Menu</caption>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>Image</th>
                    <th>Price</th>
                    <th>Special</th>
                    <th>Type</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${packageList}" var="pack">
                    <tr>
                        <td href="package.htm" package="${pack.packageId}">${pack.packageId}</td>
                        <td>${pack.name}</td>
                        <td>${pack.description}</td>
                        <td>${pack.mealCategory}</td>
                        <td>
                            <img width="120em" src=images/${pack.imageSource} alt=${pack.imageSource}></img>
                        </td>
                        <td>${pack.price}</td>
                        <td>${pack.isSpecial}</td>
                        <td>${pack.mealType}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>


