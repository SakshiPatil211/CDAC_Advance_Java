package com.demo.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Course1")
public class Course {
	@Id
	@GeneratedValue
	private int cid;
	private String cname;
	private int duration;
	@OneToMany(mappedBy="course")
	Set<Student> sset;
	
	public Course() {
		super();
	}
	
	public Course(String cname, int duration, Set<Student> sset) {
		super();
		this.cname = cname;
		this.duration = duration;
		this.sset = sset;
	}
	
	public Course(String cname, int duration) {
		super();
		this.cname = cname;
		this.duration = duration;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Set<Student> getSset() {
		return sset;
	}
	public void setSset(Set<Student> sset) {
		this.sset = sset;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", duration=" + duration + ", sset=" + sset + "]";
	}
}
