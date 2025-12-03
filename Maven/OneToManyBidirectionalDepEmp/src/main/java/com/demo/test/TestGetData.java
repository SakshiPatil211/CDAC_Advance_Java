package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public class TestGetData {

	public static void main(String[] args) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		System.out.println("Before get");
		Department dept = session.get(Department.class, 33);
		System.out.println("After get");
		System.out.println(dept);
		System.out.println("----------------------------------------------------------------------");
		
		System.out.println("Before get");
		Employee e = session.get(Employee.class, 36);
		System.out.println("After get");
		System.out.println(e);
		System.out.println(e.getDept().getDname());
		
		tr.commit();
		session.close();
		sf.close();
		
		

	}

}
