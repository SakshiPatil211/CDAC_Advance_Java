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
import com.demo.service.ProductServiceImp;
import com.demo.service.*;
import com.demo.beans.*;

@WebServlet("/showproduct")
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("user");
		
		if(user != null && user.getRole().equals("user")) {
			String btn = req.getParameter("btn");
			switch(btn) {
				case "show"->{
					int cid = Integer.parseInt(req.getParameter("category"));
					ProductService pservice = new ProductServiceImp();
					List<Product> plist = pservice.getProductByCid(cid);
					out.println("<form action='addtocart' method='post'>");
					for(Product p:plist) {
						out.println("<input type='checkbox' name='pname' id='"+p.getPid()+"' value='"+p.getPname()+"'><label for='"+p.getPid()+"'>"+p.getPname()+"</label>");
					}
					out.println("<button type='submit' name='btn' id='btn' value='cart'>Add to Cart</button>");
					out.println("</form>");
					out.println("<a href='logout'>Logout</a>");
				}
				
				case "order"->{
					RequestDispatcher rd = req.getRequestDispatcher("placeorder");
					rd.forward(req, res);
				}
			}
		}else {
			out.println("Invalid Credential");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}

}
