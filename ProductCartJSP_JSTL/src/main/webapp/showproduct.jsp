<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.demo.beans.*, java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Product</title>
</head>
<body>
	<form action="placeorder.jsp" method="post">
		<button type="submit" id="btn" name="btn">Place Order</button>
	</form>
	
	<c:forEach var="p" items="${plist}"> <%--for(Product p:plist) --%>
		<div>
			<form action="addtocart" method="post">
				Product Id: ${p.pid}<br/>
				Product Name: ${p.getPname()}<br/>
				Product Price: ${p.getPrice()}<br/>
				<input type="hidden" name="pid" id="pid" value="${p.pid}">
				<input type="hidden" name="pname" id="pname" value="${p.getPname()}">
				<input type="hidden" name="price" id="price" value="${p.getPrice()}">
				Quantity: <input type="text" id="qty" name="qty">
				<button type="submit" id="btn" name="btn">Add To cart</button>
			</form>
		</div>
	</c:forEach>
</body>
</html>