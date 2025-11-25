package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.demo.beans.*;
import com.demo.service.RegistrationService;
import com.demo.service.RegistrationServiceImp;

public class RegistrationServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		int uid = Integer.parseInt(req.getParameter("uid"));
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		String email = req.getParameter("email");
		//Users user1 = new Users(uid,uname,email,pass);
		
		RegistrationService rservice = new RegistrationServiceImp();
		int n= rservice.save(uid,uname,email,pass);
		if(n>0) {
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.forward(req, res);
		}
	}
}
