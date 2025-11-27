package com.demo.servlet;

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

import com.demo.beans.Product;
import com.demo.beans.Users;
import com.demo.service.*;

@WebServlet("/showproduct")
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("user");
		
		if(user != null && user.getRole().equals("user")) {
			ProductService pservice = new ProductServiceImp();
			List<Product> plist = pservice.getAllProduct();
			req.setAttribute("plist", plist);
			RequestDispatcher rd = req.getRequestDispatcher("showproduct.jsp");
			rd.forward(req, res);
		}else {
			out.print("<h1>Invalid credentials</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}

}
