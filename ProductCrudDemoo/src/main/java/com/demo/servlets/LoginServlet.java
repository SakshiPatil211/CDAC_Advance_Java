package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Users;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImp;

public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		LoginService lservice = new LoginServiceImp();
		Users user = lservice.validateUser(uname,pass);
		if(user!= null) {
			out.println("<h3>Login Successful</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("showproduct");
			rd.forward(req, res);
		}else {
			out.println("<h3>Login Credential Invalid</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}
}
