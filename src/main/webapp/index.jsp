<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns:th="http://www.thymeleaf.org">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Title Page</title>
</head>

<body>
	<div align="center">
	    <h2>Title List</h2>
	    
	    <table border="1" cellpadding="5">
	        <tr>
	            <th>Name</th>
	            <th>Price</th>
	        </tr>
	        <c:forEach items="${productsList}" var="product">
	        <tr>
	            <td>${product.name}</td>
	            <td>${product.price}</td>
	        </tr>
	        </c:forEach>
	    </table>
	</div>   
</body>

</html>