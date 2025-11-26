<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Using JSP expression</h2>
	Number1 : <%= request.getParameter("num1") %>
	Number2 : <%= request.getParameter("num2") %>
	Result : <%= request.getParameter("res") %>
	user : <%= session.getAttribute("user") %>
	
	<br/><br/>
	
	<h2>Using EL Language</h2>
	Number1 : ${param.num1}
	Number2 : ${param.num2}
	Result : ${param.res} 
</body>
</html>