package com.demo.servlets;

import com.demo.beans.Users;

import java.io.IOException;
import java.util.Arrays;

// ... other imports remain the same
import javax.servlet.RequestDispatcher; // New Import
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/showdata")
public class ShowDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 1. Retrieve all parameters (same as before)
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String city = request.getParameter("city");

        // 2. Handle the 'hobbie' parameter and create the String[] (same as before)
        String hobbieString = request.getParameter("hobbie");
        String[] hobbiesArray = null;

        if (hobbieString != null && !hobbieString.trim().isEmpty()) {
            hobbiesArray = Arrays.stream(hobbieString.split(","))
                               .map(String::trim)
                               .filter(s -> !s.isEmpty())
                               .toArray(String[]::new);
        } else {
            hobbiesArray = new String[0]; 
        }

        // 3. Create the Users bean object (same as before)
        Users user = new Users(fname, lname, email, gender, hobbiesArray, city);

        // 4. The attribute name "userData" will be used by the JSP to retrieve the object.
        HttpSession session = request.getSession(); 
        session.setAttribute("userData", user); 
        
        // 5. Forward the request to the JSP page
        RequestDispatcher rd = request.getRequestDispatcher("displayUser.jsp");
        rd.forward(request, response);
    }
}