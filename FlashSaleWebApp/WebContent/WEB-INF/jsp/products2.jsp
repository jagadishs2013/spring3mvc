<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- 
<h1>
	Add a Product
</h1>
<c:url var="addAction" value="/product/add"></c:url>

<form:form action="${addAction}"  commandName="product">
<table>
<c:if test="${!empty product.productName}">
<tr>
	<td>
		<form:label path="productId">
			<spring:message text="ID"></spring:message>
		</form:label>
	</td>
	<td>
		<form:input path="productId" readonly="true" size="8"  disabled="true"/>
		<form:hidden path="productId" />
	</td>
</tr>	
</c:if>
<tr>
	<td>
		<form:label path="productName">
			<spring:message text="productName"></spring:message>
		</form:label>
	</td>
	<td>
		<form:input path="productName"/>
	</td>
</tr>

<tr>
		<td colspan="2">
			<c:if test="${!empty product.productName}">
				<input type="submit"
					value="<spring:message text="Edit Product"/>" />
			</c:if>
			<c:if test="${empty product.productName}">
				<input type="submit"
					value="<spring:message text="Add Product"/>" />
			</c:if>
		</td>
	</tr>
</table>
</form:form>
<br>
-->

<!-- 
<h3>Product List</h3>
<c:if test="${!empty productList}">
	<table>
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${productList}" var="product" >
			<tr>
				<td>${product.productId}</td>
				<td>${product.productName}</td>
				<td><a href='<c:url value="/edit/${product.productId}" />' >Edit </a></td>
				<td><a href='<c:url value="/delete/${product.productId}" />' >Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<c:if test="${empty productList}">
	<table>
		<tr>
			<th>Product Name</th>
		</tr>
			<tr>
				<td>Out of Stock</td>
			</tr>
	</table>
</c:if>

-->


<h3>Product List</h3>
<c:if test="${!empty productList}">
	<table>
		<tr>
			<th>Product Name</th>
			<th>Buy</th>
			
		</tr>
		<c:forEach items="${productList}" var="product" >
			<tr>
				<td>${product.productId}</td>
				<td><a href='<c:url value="/delete/${product.productId}" />' >Click here</a></td>
				<td><a href='<c:url value="/order/add/${product.productId}" />' >Add To Cart</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

<h3>Product List</h3>
<c:if test="${!empty orderList}">
	<table>
		<tr>
			<th>Product Name</th>
			<th>Buy</th>
			
		</tr>
		<c:forEach items="${orderList}" var="product" >
			<tr>
				<td>${product.orderId}</td>
				<td><a href='<c:url value="/delete/${product.orderId}" />' >Click here</a></td>
				<td><a href='<c:url value="/order/add/${product.orderId}" />' >Add To Cart</a></td>
			</tr>
		</c:forEach>
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