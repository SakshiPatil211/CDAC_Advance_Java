<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int ans = num1 + num2;
		
		session.setAttribute("user", "userdata");
		String result = "Addition : " + ans;
	%>
	
	<jsp:forward page="displaydata.jsp">
		<jsp:param value="<%= result %>" name="res"/>
	</jsp:forward>
</body>
</html>