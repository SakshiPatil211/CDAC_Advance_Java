package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.demo.service.*;

public class ForgotPasswordServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		ForgotPasswordService fservice = new ForgotPasswordServiceImp();
		int n = fservice.resetPassword(uname, pass);
		if(n > 0) {
			out.println("<h2>Password Updated Successfully</h2>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.forward(req, res);
		}else {
			out.println("Username Invalid");
			RequestDispatcher rd = req.getRequestDispatcher("forgotpassword.html");
			rd.include(req, res);
		}
	}
}
