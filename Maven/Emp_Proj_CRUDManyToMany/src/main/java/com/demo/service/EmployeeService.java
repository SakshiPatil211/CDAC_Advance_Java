package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeService {

	boolean addNewEmployee();

	List<Employee> findAllEmployee();

	boolean deleteEmployee(int id);

	boolean updateSalaryById(int id, double sal);

	boolean addExtraEmpToProject(int eid, int pid);

	List<Employee> sortBySalary();

}
