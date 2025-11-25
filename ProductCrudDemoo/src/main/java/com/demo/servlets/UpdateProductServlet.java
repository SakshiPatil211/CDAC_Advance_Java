package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.demo.beans.*;
import com.demo.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProductServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		//Retrieve data from form
		int pid = Integer.parseInt(req.getParameter("pid"));
		String pname = req.getParameter("pname");
		int qty = Integer.parseInt(req.getParameter("qty"));
		double price = Double.parseDouble(req.getParameter("price"));
		String dt = req.getParameter("expdate");
		LocalDate ldt = LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		int cid = Integer.parseInt(req.getParameter("cid"));
		
		//send it to database for updation
		Product p = new Product(pid,pname,qty,price,ldt,cid);
		ProductService pservice = new ProductServiceImp();
		boolean status = pservice.updateproduct(p);
		RequestDispatcher rd = req.getRequestDispatcher("showproduct");
		rd.forward(req,res);
	}
}
