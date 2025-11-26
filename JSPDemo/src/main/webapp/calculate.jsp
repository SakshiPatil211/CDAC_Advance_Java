<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator</title>
</head>
<body>
	<%@ include file="MyHeader.html" %>
	<form action="result.jsp" method="post">
		Num1 : <input type="text" name="num1" id="num1" value="n1"><br/>
		Num2 : <input type="text" name="num2" id="num2" value="n2"><br/>
		<button type="submit" name="btn" id="btn">Addition</button>
	</form>
	<%@ include file="MyFooter.html" %>
</body>
</html>