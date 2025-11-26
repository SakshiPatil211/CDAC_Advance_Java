<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Product</title>
</head>
<body>
	<%--Create a object --%>
	<jsp:useBean id="p" class="com.demo.beans.Product"></jsp:useBean>
	
	<%--Assign form values to the object --%>
	<jsp:setProperty name="p" property="*"></jsp:setProperty>
	
	<%-- If you have different attribute name in the class and name field in the form then use this
	<jsp:setProperty property="pid" name="p" value="<%= Integer.parseInt(request.getParameter("pid")) %>"/>
	<jsp:setProperty property="pname" name="p" value="<%= request.getParameter("pname") %>"/>
	<jsp:setProperty property="qty" name="p" value="<%= Integer.parseInt(request.getParameter("qty")) %>"/>
	<jsp:setProperty property="price" name="p" value="<%= Double.parseDouble(request.getParameter("price")) %>"/>
	 --%>
	 
	 <%--retrieve the data from the object --%>
	 <h2>Product Data</h2>
	 Product Id : <jsp:getProperty property="pid" name="p"/>
	 Product Name : <jsp:getProperty property="pname" name="p"/>
	 Product Quantity : <jsp:getProperty property="qty" name="p"/>
	 Product Price : <jsp:getProperty property="price" name="p"/>
	
	
</body>
</html>