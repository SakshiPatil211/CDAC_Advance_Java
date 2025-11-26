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

import com.demo.beans.Users;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImp;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		//check user exist in the session
		HttpSession session  = req.getSession();
		Users user = (Users) session.getAttribute("user");
		if(user != null && user.getRole().equals("user")) {
			ProductService pservice = new ProductServiceImp();
			List<Integer> clist = pservice.getAllCategory();
			
			out.println("<form action='showproduct' method='post'>");
			out.println("<select name='category'>");
			for(int i:clist) {
				out.println("<option value='" + i + "'>" + i + "</option>");
			}
			out.println("</select>");
			out.println("<button type='submit' name='btn' id='btn' value='show'>Show Product</button>");
			out.println("<button type='submit' name='btn' id='btn' value='order'>Place Order</button>");
			out.println("</form>");
			out.println("<a href='logout'>Logout</a>");
		}else {
			out.println("Unauthorized access");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}

}
