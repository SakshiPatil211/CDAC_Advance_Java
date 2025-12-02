package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.beans.Project;

public class ProjectDaoImp implements ProjectDao{
	static SessionFactory sf = null;
	
	static {
		sf = HibernateUtil.getMySessionFatory();
	}

	public void save(Project p) {
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		session.save(p);
		tr.commit();
		session.close();	
	}	
}