<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flash Sale App</title>
</head>
<body>

<h1>PAYMENT</h1>

<c:if test="${!empty productList}">
	<table>
		<c:forEach items="${productList}" var="product" >
		
		<h4>Product ${product.productName} ordered succesfully..</h4>
			
		</c:forEach>
		<tr>
				<td><a href='<c:url value="/products" />' >Goto Home</a></td>
		</tr>
	</table>
</c:if>
<c:if test="${empty orderList}">
	<table>
		<tr>
			<th>Product Name</th>
		</tr>
			<tr>
				<td>Out of Stock</td>
			</tr>
	</table>
</c:if>

</body>
</html>