package com.demo.service;

import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImp;

public class EmployeeServiceImp implements EmployeeService {
	private EmployeeDao pdao;
	
	public EmployeeServiceImp() {
		pdao = new EmployeeDaoImp();
	}
}
