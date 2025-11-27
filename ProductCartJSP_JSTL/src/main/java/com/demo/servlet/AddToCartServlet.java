package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.Product;
import com.demo.beans.Users;
import java.util.*;

@WebServlet("/addtocart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		
		if(user!=null && user.getRole().equals("user")) {
			int pid = Integer.parseInt(request.getParameter("pid"));
			String pname = request.getParameter("pname");
			Double price = Double.parseDouble(request.getParameter("price"));
			int ord_qty = Integer.parseInt(request.getParameter("qty"));
			Set<Product> cart = (Set<Product>) session.getAttribute("cart");
			if(cart==null) {
				cart = new HashSet<>();
			}
			Product p = new Product(pid,pname,ord_qty,price,null,0);
			boolean status = cart.add(p);
			//if status is false then delete previous product with the pid
			//add new entry in the set
			session.setAttribute("cart", cart);
			cart.stream().forEach(System.out::println);
			RequestDispatcher rd = request.getRequestDispatcher("showproduct");
			rd.forward(request, response);
		}else {
			out.print("<h1>Invalid credentials</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
