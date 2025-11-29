<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.demo.beans.Users" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Details</title>
</head>
<body>

    <h2>Registration Successful!</h2>
    <h3>Submitted Details: (Data from Session)</h3>
    
    <%
        // *** KEY CHANGE: Retrieve the Users object from the SESSION Scope ***
        // Assuming the Servlet stored the data with the key "userData" in the session.
        Users user = (Users) session.getAttribute("userData"); 
    %>
    
    <%
        // Check if the user object was actually found in the session
        if (user != null) {
    %>
    
    <div class="details">
        <%-- Use JSP Expressions for simple property access --%>
        <p>First Name: <strong><%= user.getFname() %></strong></p>
        <p>Last Name: <strong><%= user.getLname() %></strong></p>
        <p>Email: <strong><%= user.getEmail() %></strong></p>
        <p>Gender: <strong><%= user.getGender() %></strong></p>
        <p>City: <strong><%= user.getCity() %></strong></p>
        
        <h4>Hobbies:</h4>
        
        <%
            // Retrieve the array of hobbies
            String[] hobbies = user.getHobbie();
            
            if (hobbies != null && hobbies.length > 0) {
        %>
            <ul>
                <%
                    // Use a scriptlet loop to iterate over the array
                    for (String hobbyItem : hobbies) {
                %>
                        <li><%= hobbyItem %></li>
                <%
                    } // end of for loop
                %>
            </ul>
        <%
            } else {
        %>
                <p>No hobbies entered.</p>
        <%
            } // end of if block for hobbies
        %>
    </div>
    
    <%
        } else {
    %>
        <p style="color: red;">Error: User data not found in the Session.</p>
    <%
        } // end of if block for user != null
    %>
    
    <hr/>
</body>
</html>