package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Faculty {
	@Id
	@GeneratedValue
	private int fid;
	private String fname;
	private String speciality;
	
	public Faculty() {
		super();
	}
	
	public Faculty(int fid, String fname, String speciality) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.speciality = speciality;
	}
	
	public Faculty(String fname, String speciality) {
		super();
		this.fname = fname;
		this.speciality = speciality;
	}
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", speciality=" + speciality + "]";
	}
	

	
}
