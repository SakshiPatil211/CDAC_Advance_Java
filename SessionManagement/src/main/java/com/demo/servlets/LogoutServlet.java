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

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("user");
		
		if(user!=null && user.getRole().equals("user")) {
			//destroy the session
			session.invalidate();
			out.println("<h3>Thank you for visiting.... do visit again...</h3>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}

}
