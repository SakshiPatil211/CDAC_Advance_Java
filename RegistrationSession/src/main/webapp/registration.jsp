<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form action="showdata" method="post">
		First Name:<input type="text" id="fname" name="fname"><br/><br/>
		Last Name:<input type="text" id="lname" name="lname"><br/><br/>
		Email:<input type="text" id="email" name="email"><br/><br/>
		<label for="gender">Gender</label><br/>
		<input type="radio" id="male" name="gender" value="male">Male
		<input type="radio" id="female" name="gender" value="female">Female <br/><br/>
		Hobbies:<textarea id="hobbie" name="hobbie"></textarea><br/><br/>
		<label for="city">Choose City</label>
		<select name="city" id="city">
			<option value="">Please Select</option>
			<option value="Pune">Pune</option>
			<option value="Mumbai">Mumbai</option>
			<option value="Satara">Satara</option>
			<option value="Sangli">Sangli</option>
		</select><br/><br/>
		
		<button type="submit" id="btn" name="btn">Register</button>
	</form>
</body>
</html>