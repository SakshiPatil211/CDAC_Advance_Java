package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;
import com.demo.beans.Project;

public interface EmployeeDao {

	boolean addNewEmployee(Employee e);

	List<Employee> findAllEmployee();

	boolean deleteEmployee(int id);

	boolean updateSalary(int id, double sal);

	Employee findById(int eid);

	boolean addProjectToEmp(Employee e, Project p);

	List<Employee> sortBySalary();

}
