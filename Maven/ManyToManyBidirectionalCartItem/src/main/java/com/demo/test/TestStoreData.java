package com.demo.test;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.*;
import java.util.*;
public class TestStoreData {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Item i1 = new Item("Chips",50 ,LocalDate.of(2026, 03, 10));
		Item i2 = new Item("Kurkure",40 ,LocalDate.of(2026, 01, 15));
		Item i3 = new Item("Nachos",60 ,LocalDate.of(2026, 11, 20));
		Item i4 = new Item("Noodles",70 ,LocalDate.of(2026, 10, 11));
		
		Set<Item> iset1 = new HashSet<Item>();
		iset1.add(i1);
		iset1.add(i2);
		iset1.add(i4);
		Cart c1 = new Cart(iset1);
		
		Set<Item> iset2 = new HashSet<Item>();
		iset2.add(i3);
		iset2.add(i1);
		Cart c2 = new Cart(iset2);
		
		Set<Item> iset3 = new HashSet<Item>();
		iset3.add(i4);
		iset3.add(i3);
		Cart c3 = new Cart(iset3);
		
		Set<Cart> cset1 = new HashSet<Cart>();
		cset1.add(c1);
		cset1.add(c2);
		i1.setCset(cset1);
		
		Set<Cart> cset2 = new HashSet<Cart>();
		cset2.add(c1);
		i2.setCset(cset2);
		
		Set<Cart> cset3 = new HashSet<Cart>();
		cset3.add(c2);
		cset3.add(c3);
		i3.setCset(cset3);
		
		
		Set<Cart> cset4 = new HashSet<Cart>();
		cset4.add(c3);
		cset4.add(c1);
		i4.setCset(cset4);
		
		session.save(c1);
		session.save(c2);
		session.save(c3);
		tr.commit();
		session.close();
		sf.close();
	}
}
