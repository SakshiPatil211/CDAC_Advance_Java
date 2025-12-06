package com.demo.beans;

public class Student {
	private int id;
	private String sname;
	private int m1;
	private int m2;
	private Address addr;
	
	public Student() {
		super();
	}

	public Student(int id, String sname, int m1, int m2, Address addr) {
		super();
		this.id = id;
		this.sname = sname;
		this.m1 = m1;
		this.m2 = m2;
		this.addr = addr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getM1() {
		return m1;
	}

	public void setM1(int m1) {
		this.m1 = m1;
	}

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", m1=" + m1 + ", m2=" + m2 + ", addr=" + addr + "]";
	}
}	
