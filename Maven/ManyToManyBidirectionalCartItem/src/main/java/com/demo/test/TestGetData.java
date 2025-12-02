package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Cart;
import com.demo.beans.Item;

public class TestGetData {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		System.out.println("before get");
		Cart c = session.get(Cart.class, 61);
		System.out.println("after get");
		System.out.println(c);
		
		System.out.println("------------------------------------------------------------------");
		
		System.out.println("before get");
		Item i = session.get(Item.class, 64);
		System.out.println("after get");
		System.out.println(i);
		System.out.println("--------------------------------------------------------------------");
		System.out.println(i.getCset());
	}

}
