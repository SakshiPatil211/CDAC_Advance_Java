package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.demo.beans.*;
public class TestStoreAddressUser {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Address a = new Address("SBRoad","Pune","152163");
		User u = new User("Sakshi","46123535",a);
		session.save(a);
		session.save(u);
		
		tr.commit();
		session.close();
		sf.close();
	}

}
