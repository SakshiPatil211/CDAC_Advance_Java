package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.demo.beans.*;

public class TestStoreData {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Address add = new Address(1, "asd", "pune", "12345");
		User u = new User(10, "sakshi", "1234567890", add);
		session.save(u);
		tr.commit();
		session.close();
		sf.close();
	}

}
