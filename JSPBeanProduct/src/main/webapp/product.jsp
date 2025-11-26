<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>
	<form action="showproduct.jsp">
		Product Id : <input type="text" name="pid" id="pid"><br/>
		Product Name : <input type="text" name="pname" id="pname"><br/>
		Product Qty : <input type="text" name="qty" id="qty"><br/>
		Product Price : <input type="text" name="price" id="price"><br/>
		<button type="submit" id="btn" name="btn">Show</button>
	</form>
</body>
</html>