package com.demo.service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.demo.dao.*;
import com.demo.beans.*;

public class ProductServiceImp implements ProductService{
	private ProductDao pdao;
	
	public ProductServiceImp() {
		pdao = new ProductDaoImp();
	}

	@Override
	public boolean addNewProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the product name");
		String pname = sc.next();
		System.out.println("Enter the quantity");
		int qty = sc.nextInt();
		System.out.println("Enter the price");
		double price = sc.nextDouble();
		System.out.println("Enter the manufacture date in (dd/MM/yyyy)");
		String dt = sc.next();
		LocalDate ldt = LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Product p = new Product(pname,qty,price,ldt);
		return pdao.save(p);
	}

	@Override
	public List<Product> displayProduct() {
		return pdao.displayProduct();
	}

	@Override
	public boolean deleteById(int id) {
		return pdao.deleteById(id);
	}

	@Override
	public boolean modifySalary(int id, int qty, double price) {
		return pdao.modifySalary(id,qty,price);
	}

	@Override
	public Product findById(int id) {
		return pdao.findById(id);
	}

	@Override
	public List<Product> displaySorted() {
		return pdao.displaySorted();
	}

}
