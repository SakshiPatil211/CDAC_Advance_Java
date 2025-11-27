<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
</head>
<body>
	<h2>Your order is placed successfully</h2>
    <h3>Your bill amount <%=request.getParameter("total") %> successfully</h3>
    <h4>Your order will be delivered in 2 days</h4>
    <h5>Thank you for visiting , do visit again</h5>
    <%--remove the session --%>
  	<% session.invalidate();%>
  	<jsp:include page="login.jsp"></jsp:include>
</body>
</html>