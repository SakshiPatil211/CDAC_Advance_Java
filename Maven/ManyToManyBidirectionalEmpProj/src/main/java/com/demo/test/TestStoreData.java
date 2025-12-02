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
		
		Employee e1 = new Employee("Sakshi",LocalDate.of(2025, 11, 02),50000);
		Employee e2 = new Employee("Anushka",LocalDate.of(2025, 10, 02),55000);
		Employee e3 = new Employee("Nikita",LocalDate.of(2025, 11, 10),57000);
		Employee e4 = new Employee("Sanika",LocalDate.of(2025, 11, 11),58000);
		
		Set<Employee> eset1 = new HashSet<>();
		eset1.add(e1);
		eset1.add(e2);
		eset1.add(e3);
		Project p1 = new Project("p1",LocalDate.of(2021, 11, 11),eset1);
		
		Set<Employee> eset2 = new HashSet<>();
		eset2.add(e4);
		eset2.add(e3);
		eset2.add(e2);
		Project p2 = new Project("p2",LocalDate.of(2020, 10, 10),eset2);
		
		Project p3 = new Project("p3",LocalDate.of(2022, 11, 15),eset1);
		
		Set<Project> pset1 = new HashSet<>();
		pset1.add(p1);
		pset1.add(p3);
		e1.setPset(pset1);
		
		Set<Project> pset2 = new HashSet<>();
		pset2.add(p1);
		pset2.add(p2);
		pset2.add(p3);
		e2.setPset(pset2);
		
//		Set<Project> pset3 = new HashSet<>();
//		pset3.add(p1);
//		pset3.add(p2);
//		pset3.add(p3);
//		e3.setPset(pset3);
		e3.setPset(pset2);
		
		Set<Project> pset4 = new HashSet<>();
		pset4.add(p2);
		e4.setPset(pset4);
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		tr.commit();
		session.close();
		sf.close();
	}

}
