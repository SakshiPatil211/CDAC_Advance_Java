package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Faculty;

public class TestGetData {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Faculty f = session.get(Faculty.class, 21);
		System.out.println(f);
		Course c = session.get(Course.class, 23);
		System.out.println(c);
		System.out.println(c.getFaculty());
		tr.commit();
		session.close();
		sf.close();
	}
}
