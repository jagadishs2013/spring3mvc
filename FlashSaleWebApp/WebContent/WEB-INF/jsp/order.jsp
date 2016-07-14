<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flash Sale App</title>
</head>
<body>

<h1> PAYMENT </h1>

<h3>You have ordered below items</h3>
<c:if test="${!empty productList}">
	<table border="2">
		<tr>
			<th>Order</th>
			<th>Price</th>
			<th>Pay</th>
			
		</tr>
		<c:forEach items="${productList}" var="product" >
			<tr>
				<td>${product.productName}</td>
				<td>${product.price}</td>
				<td><a href='<c:url value="/order/pay/${product.productId}" />' >Pay</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>