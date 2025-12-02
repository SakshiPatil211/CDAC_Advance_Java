package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Employee;
import com.demo.beans.Project;

public class TestGetData {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		System.out.println("before get");
		Project p = session.get(Project.class, 49);
		System.out.println("after get");
		System.out.println(p);
		
		System.out.println("------------------------------------------------------------------");
		
		System.out.println("before get");
		Employee e = session.get(Employee.class, 46);
		System.out.println("after get");
		System.out.println(e);
		System.out.println("--------------------------------------------------------------------");
		System.out.println(e.getPset());
	}

}
