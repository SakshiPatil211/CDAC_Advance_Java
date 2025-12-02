package com.demo.dao;

import org.hibernate.SessionFactory;

public class EmployeeDaoImp implements EmployeeDao{
	static SessionFactory sf = null;
	
	static {
		if(sf==null) {
			sf = HibernateUtil.getMySessionFatory();
		}
	}
}