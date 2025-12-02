package com.demo.beans;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Project1")
public class Project {
	@Id
	@GeneratedValue
	private int pid;
	private String pname;
	private LocalDate startdate;
	@ManyToMany(mappedBy="pset",cascade=CascadeType.ALL)
	Set<Employee> elsit;
	
	public Project() {
		super();
	}

	public Project(String pname, LocalDate startdate, Set<Employee> elsit) {
		super();
		this.pname = pname;
		this.startdate = startdate;
		this.elsit = elsit;
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

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public Set<Employee> getElsit() {
		return elsit;
	}

	public void setElsit(Set<Employee> elsit) {
		this.elsit = elsit;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", pname=" + pname + ", startdate=" + startdate + ", elsit=" + elsit + "]";
	}	
}
