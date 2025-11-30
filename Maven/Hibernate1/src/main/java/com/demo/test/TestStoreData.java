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
		
		MyUsers u1 = new MyUsers(10,"Sakshi","sak@gmail.com");
		MyUsers u2 = new MyUsers(11,"Chavan","chvan@gmail.com");
		MyProduct p1 = new MyProduct("Chair",10,10000);
		MyProduct p2 = new MyProduct("Chair",10,10000);
		session.save(u1);
		session.save(u2);
		session.save(p1);
		session.save(p2);
		tr.commit();
		session.close();
		sf.close();

	}

}
