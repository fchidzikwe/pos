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
    <title>User Login</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Registration Form</h2>
  
    <form:form method="POST" modelAttribute="user">
        <form:input type="hidden" path="userId" id="userId"/>
        <table>
            <tr>
                <td><label for="username">User Name: </label> </td>
                <td><form:input path="username" id="username"/></td>
                <td><form:errors path="username" cssClass="username"/></td>
            </tr>
         
            <tr>
                <td><label for="password">Password: </label> </td>
                <td><form:input path="password" id="password"/></td>
                <td><form:errors path="password" cssClass="error"/></td>
            </tr>
            
             <tr>
             <a href="success.jsp">Register new User</a>
              
            </tr>
     
          
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Login"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/list' />">List of All Users</a>
</body>
</html>
