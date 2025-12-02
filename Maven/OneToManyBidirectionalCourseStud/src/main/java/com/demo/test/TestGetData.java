package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Student;

public class TestGetData {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		System.out.println("before get");
		Course c = session.get(Course.class, 39);
		System.out.println("after get");
		System.out.println(c);
		System.out.println(c.getSset());
		
		System.out.println("----------------------------------------------------------------------");
		System.out.println("before get");
		Student s = session.get(Student.class, 44);
		System.out.println("after get");
		System.out.println(s.getCourse());
		System.out.println(s.getCourse().getCname());
	}
}
