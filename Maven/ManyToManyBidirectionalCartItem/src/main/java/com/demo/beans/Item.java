package com.demo.beans;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Item1")
public class Item {
	@Id
	@GeneratedValue
	private int iid;
	private String iname;
	private LocalDate expdate;
	private double price;
	@ManyToMany
	@JoinColumn(name="cid")
	Set<Cart> cset;
	
	public Item() {
		super();
	}
	
	public Item(String iname, LocalDate expdate, double price, Set<Cart> cset) {
		super();
		this.iname = iname;
		this.expdate = expdate;
		this.price = price;
		this.cset = cset;
	}
	
	public Item(String iname, double price, LocalDate expdate) {
		super();
		this.iname = iname;
		this.price = price;
		this.expdate = expdate;
	}
	
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getExpdate() {
		return expdate;
	}
	public void setExpdate(LocalDate expdate) {
		this.expdate = expdate;
	}
	public Set<Cart> getCset() {
		return cset;
	}
	public void setCset(Set<Cart> cset) {
		this.cset = cset;
	}
	@Override
	public String toString() {
		return "Item [iid=" + iid + ", iname=" + iname + ", Price=" + price + ", expdate=" + expdate + "]";
	}
}
