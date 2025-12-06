package com.demo.beans;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employee2")
public class Employee {
	@Id
	@GeneratedValue
	private int empid;
	private String ename;
	private LocalDate hiredate;
	private double sal;
	@ManyToMany(fetch=FetchType.EAGER)
	//@JoinColumn(name="project_id")
	@JoinTable(
 	        name = "emp_project",
 	        joinColumns = @JoinColumn(name = "empid"),
 	        inverseJoinColumns = @JoinColumn(name = "pid")
 	    )
	Set<Project> pset;
	
	public Employee() {
		super();
	}
	
	public Employee(String ename, LocalDate hiredate, double sal, Set<Project> pset) {
		super();
		this.ename = ename;
		this.hiredate = hiredate;
		this.sal =sal;
		this.pset = pset;
	}
	
	public Employee(String ename, double sal, LocalDate hiredate) {
		super();
		this.ename = ename;
		this.sal = sal;
		this.hiredate = hiredate;
	}
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public LocalDate getHiredate() {
		return hiredate;
	}
	public void setHiredate(LocalDate hiredate) {
		this.hiredate = hiredate;
	}
	public Set<Project> getPset() {
		return pset;
	}
	public void setPset(Set<Project> pset) {
		this.pset = pset;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", hiredate=" + hiredate + ", sal=" + sal + "]";
	}
}
