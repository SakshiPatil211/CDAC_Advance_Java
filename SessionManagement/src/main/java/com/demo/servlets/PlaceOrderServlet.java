package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.Users;

@WebServlet("/placeorder")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("user");
		
		PrintWriter out = res.getWriter();
		if(user != null && user.getRole().equals("user")) {
			//retrieve cart from the session
			List<String> cart = (List<String>) session.getAttribute("cart");
			//display the cart
			cart.stream().forEach(s->out.println(s));
			out.println();
			out.println("\n Your order placed successfully\n");
			out.println();
			out.println("<a href='logout'>Logout</a>");
			
		}
	}

}
