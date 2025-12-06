package com.demo.beans;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class NonPerishableProduct extends Product{
	private int gaurantee;

	public NonPerishableProduct() {
		super();
	}

	public NonPerishableProduct(int pid, String pname, int qty, double price, LocalDate mfgdate, int gaurantee) {
		super(pid, pname, qty, price, mfgdate);
		this.gaurantee = gaurantee;
	}

	public int getGaurantee() {
		return gaurantee;
	}

	public void setGaurantee(int gaurantee) {
		this.gaurantee = gaurantee;
	}

	@Override
	public String toString() {
		return super.toString()+"NonPerishableProduct [gaurantee=" + gaurantee + "]";
	}
}
