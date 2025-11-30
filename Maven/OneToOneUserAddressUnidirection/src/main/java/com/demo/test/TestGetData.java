package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.User;

public class TestGetData {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		System.out.println("Before Get");
		User u = session.get(User.class, 4);
		System.out.println("Before Get");
		tr.commit();
		System.out.println(u);
		session.close();
		sf.close();
	}

}
