package com.demo.service;

import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImp;
import com.demo.dao.ProjectDao;
import com.demo.dao.ProjectDaoImp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.demo.beans.*;

public class EmployeeServiceImp implements EmployeeService {
	private EmployeeDao edao;
	private ProjectDao pdao;
	public EmployeeServiceImp() {
		edao = new EmployeeDaoImp();
		pdao = new ProjectDaoImp();
	}

	@Override
	public boolean addNewEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employee name");
		String ename = sc.next();
		System.out.println("Enter the hiredate in(dd/MM/yyyy");
		String  dt = sc.next();
		LocalDate ldt = LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Enter the salary of employee");
		double sal = sc.nextDouble();
		Employee e = new Employee(ename,sal,ldt);
		return edao.addNewEmployee(e);
	}

	@Override
	public List<Employee> findAllEmployee() {
		return edao.findAllEmployee();
	}

	@Override
	public boolean deleteEmployee(int id) {
		return edao.deleteEmployee(id);
	}

	@Override
	public boolean updateSalaryById(int id, double sal) {
		return edao.updateSalary(id,sal);
	}

	@Override
	public boolean addExtraEmpToProject(int eid, int pid) {
		Employee e = edao.findById(eid);
		Project p = pdao.findById(pid);
		if(e!=null && p!=null) {
			return edao.addProjectToEmp(e,p);
		}
		return false;
	}

	@Override
	public List<Employee> sortBySalary() {
		return edao.sortBySalary();
	}
}
