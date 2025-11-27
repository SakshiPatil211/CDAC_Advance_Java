<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.demo.beans.*, java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Place Order</title>
</head>
<body>
	<% double totalamt=0;%>
	<table border="3">
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Order qty</th>
			<th>Product Price</th>
			<th>Amount</th>
		</tr>
	
		<c:forEach var="p" items="${cart}">
			<c:set var="amount" value="${p.qty*p.price}"></c:set>
			<c:set var="totalamt" value="${totalamt+amount}"></c:set>
			<tr>
				<td>${p.pid}</td>
				<td>${p.pname}</td>
				<td>${p.qty}</td>
				<td>${p.price}</td>
				<td>${amount}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4">Total Bill Amount</td>
			<td>${totalamt}</td>
		</tr>
	</table>
	
	<form action="payment.jsp" method="post">
		<input type="hidden" id="total" name="total" value="${totalamt}">
		<button type="submit" id="btn" name="btn">Pay Bill</button>
	</form>
</body>
</html>