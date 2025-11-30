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
		
		Address a = new Address("s.b.road","pune","13213");
		User u = new User("Sanika","1234536",a);
		a.setUser(u);
		session.save(a);
		session.save(u);
		tr.commit();
		session.close();
		sf.close();		
	}

}
