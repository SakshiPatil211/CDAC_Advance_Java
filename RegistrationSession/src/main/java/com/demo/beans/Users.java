package com.demo.beans;

import java.util.Arrays;

public class Users {
	private String fname;
	private String lname;
	private String email;
	private String gender;
	private String[] hobbie;
	private String city;
	
	public Users() {
		super();
	}

	public Users(String fname, String lname, String email, String gender, String[] hobbie, String city) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.gender = gender;
		this.hobbie = hobbie;
		this.city = city;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getHobbie() {
		return hobbie;
	}

	public void setHobbie(String[] hobbie) {
		this.hobbie = hobbie;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Registration [fname=" + fname + ", lname=" + lname + ", email=" + email + ", gender=" + gender
				+ ", hobbie=" + Arrays.toString(hobbie) + ", city=" + city + "]";
	}
	
	
	
	
}
