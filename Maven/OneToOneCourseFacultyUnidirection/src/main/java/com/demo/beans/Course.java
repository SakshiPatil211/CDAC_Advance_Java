package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private int cid;
	private String cname;
	private int duration;
	@OneToOne(fetch=FetchType.LAZY)
	private Faculty faculty;
	
	public Course() {
		super();
	}
	public Course(int cid, String cname, int duration, Faculty faculty) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.duration = duration;
		this.faculty = faculty;
	}
	public Course(String cname, int duration, Faculty faculty) {
		super();
		this.cname = cname;
		this.duration = duration;
		this.faculty = faculty;
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
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", duration=" + duration + ", faculty=" + faculty + "]";
	}
}
