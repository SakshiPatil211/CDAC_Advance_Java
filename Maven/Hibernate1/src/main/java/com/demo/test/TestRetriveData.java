package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.MyProduct;

public class TestRetriveData {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		//Retrieve the product
		MyProduct p1 = session.get(MyProduct.class, 7);
		MyProduct p2 = session.get(MyProduct.class, 6);
		tr.commit();
		System.out.println(p1);
		System.out.println(p2);
		session.close();
		sf.close();
		
	}

}
