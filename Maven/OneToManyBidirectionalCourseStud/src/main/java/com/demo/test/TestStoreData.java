package com.demo.test;

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
		
		Course c1 = new Course("DAC",6);
		Course c2 = new Course("DBDA",6);
		
		Student s1 = new Student("Sakshi",1,c1);
		Student s2 = new Student("Sanika",2,c1);
		Student s3 = new Student("Anushka",3,c2);
		Student s4 = new Student("Nikita",4,c2);
		
		Set<Student> slist1 = new HashSet<>();
		slist1.add(s1);
		slist1.add(s2);
		c1.setSset(slist1);
		
		Set<Student> slist2 = new HashSet<>();
		slist2.add(s3);
		slist2.add(s4);
		c2.setSset(slist2);
		
		session.save(c1);
		session.save(c2);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		tr.commit();
		session.close();
		sf.close();
	}
}