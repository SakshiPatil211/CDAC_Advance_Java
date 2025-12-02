package com.demo.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Cart1")
public class Cart {
	@Id
	@GeneratedValue
	private int cid;
	@ManyToMany(mappedBy="cset",cascade=CascadeType.ALL)
	Set<Item> iset;
	
	public Cart() {
		super();
	}
	
	public Cart(Set<Item> iset) {
		super();
		this.iset = iset;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Set<Item> getIset() {
		return iset;
	}
	public void setIset(Set<Item> iset) {
		this.iset = iset;
	}

	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", iset=" + iset + "]";
	}
}
