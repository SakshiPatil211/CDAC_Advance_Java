package com.demo.beans;

import java.time.LocalDate;

public class Product {
	private int pid;
	private String pname;
	private int qty;
	private double price;
	private LocalDate date;
	
	public Product() {
		super();
	}

	public Product(int pid, String pname, int qty, double price, LocalDate date) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.date = date;
	}
	public Product(String pname, int qty, double price, LocalDate date) {
		super();
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.date = date;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + ", date=" + date
				+ "]";
	}
	
	
	
}
