package com.demo.service;

import com.demo.dao.ProjectDao;
import com.demo.dao.ProjectDaoImp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.demo.beans.*;

public class ProjectServiceImp implements ProjectService{
	private ProjectDao pdao;
	
	public ProjectServiceImp() {
		this.pdao = new ProjectDaoImp();
	}

	public void addProject() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter project name");
		String pname = sc.next();
		
		System.out.println("Enter the Start Date(dd/MM/yyyy");
		String dt = sc.next();
		LocalDate ldt = LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Project p = new Project(pname,ldt);
		pdao.save(p);
		
	}
}
