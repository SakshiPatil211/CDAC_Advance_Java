package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Address;
import com.demo.beans.User;

public class TestGetData {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		System.out.println("Before get");
		User u = session.get(User.class, 12);
		//User u = session.load(User.class, 12);
		Address a = session.get(Address.class, 11);
		System.out.println("After get");
		tr.commit();
		System.out.println(u);
		System.out.println(a);
		System.out.println(a.getUser());
		System.out.println(u.getUname());
		session.close();
		sf.close();
	}
}
