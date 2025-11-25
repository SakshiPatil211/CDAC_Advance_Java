package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.demo.service.*;
import com.demo.beans.Product;

public class ShowProductServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		ProductService pservice = new ProductServiceImp();
		List<Product> plist = pservice.getAllProducts();
		
		out.println("<table border=1><tr> <td>PID</td> <td>PName</td> <td>Qty</td> <td>Price</td> <td>ExpDate</td> <td>Cid</td> <td>Action</td></tr>");
		for(Product p:plist) {
			out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getQty()+"</td><td>"+p.getPrice()+"</td><td>"+p.getDate()+"</td><td>"+p.getCid()+"</td>");
			out.println("<td><a href='deleteproduct?pid="+p.getPid()+"'>delete</a>/<a href='editproduct?pid="+p.getPid()+"'>edit</a></td></tr>");
		}
		out.println("</table>");
		out.println("<a href='addproduct.html'>Add Product</a>");
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		doPost(req,res);
	}
}