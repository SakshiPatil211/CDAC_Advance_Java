package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieservlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String nm = req.getParameter("nm");	
		String btn = req.getParameter("btn");
		
		switch(btn) {
			case "add"-> {
				String val = req.getParameter("val");
				Cookie c = new Cookie(nm, val);
				res.addCookie(c);
				out.println("<h2>Cookie Added</h2>");
			}
			
			case "del"-> {
				Cookie[] carr = req.getCookies();
				for(Cookie ck : carr) {
					if(ck.getName().equals(nm)) {
						ck.setMaxAge(0);
						res.addCookie(ck);
						out.println("<h2>Cookie Deleted " + nm +"</h2>");
						break;
					}
				}
			}
			
			case "show"->{
				Cookie[] carr = req.getCookies();
				for(Cookie c : carr) {
					out.println("<h2>Name: " + c.getName() + " Value: " + c.getValue() + "</h2>");
				}
			}
		} 
		
		RequestDispatcher rd = req.getRequestDispatcher("cookies.html");
		rd.include(req, res);
		
	}

}
