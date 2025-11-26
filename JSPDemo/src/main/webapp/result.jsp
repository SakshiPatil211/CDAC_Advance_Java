<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Addition Result</title>
</head>
<body>
	<%@ include file="MyHeader.html" %>
	<%
		int n1 = Integer.parseInt(request.getParameter("num1"));
		int n2 = Integer.parseInt(request.getParameter("num2"));
		int ans = n1 + n2;
	%>
	
	<h2>Addition: <%= ans %></h2>
	<%@ include file="MyFooter.html" %>
</body>
</html>