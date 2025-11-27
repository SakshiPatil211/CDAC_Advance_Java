<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="validateuser" method="post">
		Username: <input type="text" id="uname" name="uname">
		Password: <input type="text" id="pass" name="pass">
		<button type="submit" id="btn" name="btn">Login</button>
	</form>
</body>
</html>