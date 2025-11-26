package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.Users;
import com.demo.service.*;

@WebServlet("/validateuser")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String uname= req.getParameter("uname");
		String pass = req.getParameter("pass");
		LoginService lservice = new LoginServiceImp();
		Users u = lservice.validateuser(uname,pass);
		
		if(u!=null) {
			//store user in session
			HttpSession session = req.getSession();
			if(session.isNew()) {
				out.println("<h3>new session</h3>");
				session.setMaxInactiveInterval(20000);
			}
			session.setAttribute("user", u);
			RequestDispatcher rd = req.getRequestDispatcher("category");
			rd.forward(req, res);
		}else {
			//if username and password is wrong
			out.println("<h2>Invalid credential</h2>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}
}
