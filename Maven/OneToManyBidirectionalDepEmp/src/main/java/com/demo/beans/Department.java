package com.demo.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue
	private int deptId;
	private String dname;
	private String dloc;
	@OneToMany(mappedBy="dept")
	Set<Employee> eset;
	public Department() {
		super();
	}
	public Department(String dname, String dloc, Set<Employee> eset) {
		super();
		this.dname = dname;
		this.dloc = dloc;
		this.eset = eset;
	}
	public Department(String dname, String dloc) {
		super();
		this.dname = dname;
		this.dloc = dloc;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDloc() {
		return dloc;
	}
	public void setDloc(String dloc) {
		this.dloc = dloc;
	}
	public Set<Employee> getEset() {
		return eset;
	}
	public void setEset(Set<Employee> eset) {
		this.eset = eset;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", dname=" + dname + ", dloc=" + dloc + ", eset=" + eset + "]";
	}
	
	
}
