<%-- 
    Document   : registration
    Created on : Jun 18, 2016, 7:37:45 AM
    Author     : Administrator
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Product Registration Form</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Registration Form</h2>
  
    <form:form method="POST" modelAttribute="product">
        <form:input type="hidden" path="productId" id="productId"/>
        <table>
            <tr>
                <td><label for="name">Name: </label> </td>
                <td><form:input path="productName" id="productName"/></td>
                <td><form:errors path="productName" cssClass="productName"/></td>
            </tr>
         
            <tr>
                <td><label for="productCategory">Product Category: </label> </td>
                <td><form:input path="productCategory" id="productCategory"/></td>
                <td><form:errors path="productCategory" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="productPrice">Price: </label> </td>
                <td><form:input path="productPrice" id="productPrice"/></td>
                <td><form:errors path="productPrice" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="productCode">Code: </label> </td>
                <td><form:input path="productCode" id="productCode"/></td>
                <td><form:errors path="productCode" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Add Product"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/list' />">List of All products</a>
</body>
</html>
