<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>${message}</h3>
	<form action="/SpringMVCProduct/login/validateUser" method="GET">
		Username:<input type="text" id="uname" name="uname" value="uname"><br />
		Password:<input type="text" id="pass" name="pass" value="pass"><br />
		<button type="submit" id="login" name="login" value="login">Login</button>
	</form>
</body>
</html>