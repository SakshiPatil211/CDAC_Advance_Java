package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import com.demo.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteProductServlet extends HttpServlet{
	public void doGet(HttpServletRequest req ,HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		int pid = Integer.parseInt(req.getParameter("pid"));
		ProductService pservice = new ProductServiceImp();
		boolean status = pservice.deleteByIdProduct(pid);
		RequestDispatcher rd = req.getRequestDispatcher("showproduct");
		rd.forward(req, res);
	}
}
