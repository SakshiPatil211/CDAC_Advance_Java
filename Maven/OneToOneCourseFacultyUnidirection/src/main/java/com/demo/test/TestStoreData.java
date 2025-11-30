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
		
		Faculty f1 = new Faculty("Sakshi Patil","JAVA");
		Faculty f2 = new Faculty("Sakshi Chavan","WPT");
		Course c1 = new Course("DAC",6,f1);
		Course c2 = new Course("DAC",6,f2);
		session.save(f1);
		session.save(f2);
		session.save(c1);
		session.save(c2);
		tr.commit();
		session.close();
		sf.close();
		
	}

}
