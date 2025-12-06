package com.demo.dao;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.beans.Employee;
import com.demo.beans.Project;

public class EmployeeDaoImp implements EmployeeDao{
	static SessionFactory sf = null;
	
	static {
		if(sf==null) {
			sf = HibernateUtil.getMySessionFatory();
		}
	}

	@Override
	public boolean addNewEmployee(Employee e) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(e);
		tr.commit();
		session.close();
		return true;
	}

	@Override
	public List<Employee> findAllEmployee() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		List<Employee> elist = session.createQuery("from Employee",Employee.class).list();
		tr.commit();
		session.close();
		return elist;
	}

	@Override
	public boolean deleteEmployee(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		//bring the object into session
		boolean flag = false;
		Employee e = session.get(Employee.class, id);
		if(e!=null) {
			session.delete(e);
			flag = true;
		}
		tr.commit();
		session.close();
		return flag;
	}

	@Override
	public boolean updateSalary(int id, double sal) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		boolean flag = false;
		Employee e = session.get(Employee.class, id);
		if(e!=null) {
			e.setSal(sal);
			session.merge(e);
			flag = true;
		}
		tr.commit();
		session.close();
		return flag;
	}

	@Override
	public Employee findById(int eid) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Employee e = session.get(Employee.class, eid);
		if(e!=null) {
			tr.commit();
			session.close();
			return e;
		}
		return null;
	}

	@Override
	public boolean addProjectToEmp(Employee e, Project p) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		e.getPset().add(p);
		p.getEset().add(e);
		session.update(e);
		tr.commit();
		session.close();
		return true;
	}

	@Override
	public List<Employee> sortBySalary() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		List<Employee> elist = session.createQuery("from Employee e1 order by e1.sal",Employee.class).list();
		return elist;
	}
}