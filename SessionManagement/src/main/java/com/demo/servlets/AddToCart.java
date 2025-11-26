package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.demo.beans.*;
import java.util.*;

@WebServlet("/addtocart")
public class AddToCart extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("user");
		
		if(user!= null) {
			List<String> cart = (List<String>) session.getAttribute("cart");
			if(cart == null) {
				cart = new ArrayList<>();
			}
			//retrieve checkbox values
			String[] parr = req.getParameterValues("pname");
			for(String s:parr) {
				cart.add(s);
			}
			
			out.println("<h2>Cart</h2>");
			session.setAttribute("cart",cart);
			RequestDispatcher rd = req.getRequestDispatcher("category");
			rd.forward(req, res);
		}else {
			out.println("<h1>Unautherized access</h1>");
			
			RequestDispatcher rd = req.getRequestDispatcher("Login.html");
			rd.include(req, res);
		}
	}
}
