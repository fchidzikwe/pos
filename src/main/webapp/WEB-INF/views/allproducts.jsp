<%-- 
    Document   : allproducts
    Created on : Jun 18, 2016, 7:33:24 AM
    Author     : Administrator
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Point of Sale System</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of Products</h2>  
    <table>
        <tr>
            <td>Name</td><td>Category</td><td>Price</td><td>code</td><td></td>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
            <td>${product.productName}</td>
            <td>${product.productCategory}</td>
            <td>${product.productPrice}</td>
            <td><a href="<c:url value='/edit-${product.productCode}-product' />">${product.productCode}</a></td>
            <td><a href="<c:url value='/delete-${product.productCode}-product' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/new' />">Add New Product</a>
</body>
</html>
