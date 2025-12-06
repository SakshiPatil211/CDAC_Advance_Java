package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.beans.Employee;
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

	@Override
	public Project findById(int pid) {
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Project p = session.get(Project.class, pid);
		if(p!=null) {
			tr.commit();
			session.close();
			return p;
		}
		return null;
	}

	@Override
	public List<Project> findAllProject() {
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		List<Project> plist = session.createQuery("from Project",Project.class).list();
		return plist;
	}

	@Override
	public boolean deleteProject(int id) {
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Project p = session.get(Project.class, id);
		boolean flag = false;
		if(p!=null) {
			session.delete(p);
			flag = true;
		}
		tr.commit();
		session.close();
		return flag;
	}

	@Override
	public boolean updateProjectById(int id, String pname) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		boolean flag = false;
		Project p = session.get(Project.class, id);
		if(p!=null) {
			p.setPname(pname);
			session.merge(p);
			flag = true;
		}
		tr.commit();
		session.close();
		return flag;
	}	
}