package com.demo.test;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.demo.beans.*;
import java.util.*;
import java.util.HashSet;
public class TestStoreData {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Department d1 = new Department("HR","Pune");
		Department d2 = new Department("Technical","Pune");
		
		Employee e1 = new Employee("Sakshi",LocalDate.of(2025, 11, 11),40000,d1);
		Employee e2 = new Employee("Sanika",LocalDate.of(2025, 11, 12),50000,d1);
		Employee e3 = new Employee("Anushka",LocalDate.of(2025, 10, 11),40000,d2);
		Employee e4 = new Employee("Nikita",LocalDate.of(2025, 12, 01),50000,d2);
		
		Set<Employee> eset1 = new HashSet<Employee>();
		eset1.add(e1);
		eset1.add(e2);
		d1.setEset(eset1);
		
		Set<Employee> eset2 = new HashSet<Employee>();
		eset2.add(e3);
		eset2.add(e4);
		d2.setEset(eset2);
		
		session.save(d1);
		session.save(d2);
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		tr.commit();
		session.close();
		sf.close();
	}

}
