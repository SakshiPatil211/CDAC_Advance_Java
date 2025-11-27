package com.demo.beans;

public class Users {
	private int uid;
	private String uname;
	private String email;
	private String password;
	private String role;
	public Users() {
		super();
	}
	public Users(int uid, String uname, String email, String password,String role) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.email = email;
		this.password = password;
		this.role = "user";
	}
	
	public Users(int uid, String uname, String email,String role) {
		this.uid = uid;
		this.uname = uname;
		this.email = email;
		this.role = "user";
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", email=" + email + ", Role=" + role + "]";
	}
}
