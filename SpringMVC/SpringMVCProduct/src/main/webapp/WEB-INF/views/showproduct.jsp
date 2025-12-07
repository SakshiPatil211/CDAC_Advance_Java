<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Qty</th>
			<th>Product Price</th>
			<th>Product MfgDate</th>
			<th>Product CID</th>
			<th>Action</th>
		</tr>
		
		<c:forEach var="prod" items="${plist}">
			<tr>
				<td>${prod.pid}</td>
				<td>${prod.pname}</td>
				<td>${prod.qty}</td>
				<td>${prod.price}</td>
				<td>${prod.mfgdate}</td>
				<td>${prod.cid}</td>
				<td><a href="deleteproduct/${prod.pid}">Delete</a>/<a href="editproduct/${prod.pid}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="addproduct">Add Product</a>
</body>
</html>