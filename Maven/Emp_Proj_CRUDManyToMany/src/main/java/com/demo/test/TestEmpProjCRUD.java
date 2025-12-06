package com.demo.test;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.beans.Project;
import com.demo.service.*;
public class TestEmpProjCRUD {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProjectService pservice = new ProjectServiceImp();
		EmployeeService eservice = new EmployeeServiceImp();
		
		int choice=0;
		do {
			System.out.println("1. Add project");
			System.out.println("2. Add Employees");
		    System.out.println("3. show all employees");
		    System.out.println("4. delete employee");
			System.out.println("5. update Employees salary");
			System.out.println("6. Add employee in existing project");
			System.out.println("7. display employee in sorted order");
			
			System.out.println("8. show all projects");
			System.out.println("9. delete project");
			System.out.println("10. update Project name");
			System.out.println("11. Add project in existing employee");
			System.out.println("11. display project in sorted order");
		    System.out.println("12. exit");
		    System.out.println("Enter choice: ");
		    choice = sc.nextInt();
		    
		    switch(choice) {
		    	case 1->{
		    		pservice.addProject();
		    	}
		    	
		    	case 2->{
		    		boolean status = eservice.addNewEmployee();
		    		if(status) {
		    			System.out.println("Employee addedd");
		    		}else {
		    			System.out.println("Employee not added");
		    		}
			    }
		    	
		    	case 3->{
			    	List<Employee> elist = eservice.findAllEmployee();
			    	if(elist != null) {
			    		elist.stream().forEach(System.out::println);
		    		}else {
		    			System.out.println("Employee empty");
		    		}
			    	
			    }
		    	
		    	case 4->{
		    		System.out.println("Enter the Employee eid");
		    		int id = sc.nextInt();
			    	boolean status = eservice.deleteEmployee(id);
			    	if(status) {
		    			System.out.println("Employee deleted");
		    		}else {
		    			System.out.println("Employee not added");
		    		}
			    }
		    	
		    	case 5->{
		    		System.out.println("Enter the Employee id");
		    		int id = sc.nextInt();
		    		System.out.println("Enter the new salary");
		    		double sal = sc.nextDouble();
		    		boolean status = eservice.updateSalaryById(id,sal);
		    		if(status) {
		    			System.out.println("Employee's salary updated");
		    		}else {
		    			System.out.println("Employee not added");
		    		}
			    	
			    }
		    	
		    	case 6->{
		    		System.out.println("Enter the Employee id");
		    		int eid = sc.nextInt();
		    		System.out.println("Entre the project id");
		    		int pid = sc.nextInt();
		    		boolean status = eservice.addExtraEmpToProject(eid,pid);
		    		if(status) {
		    			System.out.println("Employee addedd");
		    		}else {
		    			System.out.println("Employee not added");
		    		}
		    	}
		    	
		    	case 7->{
		    		List<Employee> elist = eservice.sortBySalary();
		    		elist.stream().forEach(System.out::println);
		    		
		    	}
		    	
		    	case 8->{
		    		List<Project> plist = pservice.findAllProject();
			    	if(plist != null) {
			    		plist.stream().forEach(System.out::println);
		    		}else {
		    			System.out.println("Employee empty");
		    		}	
		    	}
		    	
		    	case 9->{
		    		System.out.println("Enter the Project pid");
		    		int id = sc.nextInt();
			    	boolean status = pservice.deleteProject(id);
			    	if(status) {
		    			System.out.println("Employee deleted");
		    		}else {
		    			System.out.println("Employee not added");
		    		}
		    	}
		    	
		    	case 10->{
		    		System.out.println("Enter the Project id");
		    		int id = sc.nextInt();
		    		System.out.println("Enter the new project name");
		    		String pname = sc.next();
		    		boolean status = pservice.updateProjectById(id,pname);
		    		if(status) {
		    			System.out.println("Employee's salary updated");
		    		}else {
		    			System.out.println("Employee not added");
		    		}
		    		
		    	}
		    	case 11->{
			    	System.out.println("Thanks for visiting");
			    }
		    	
		    	default->{
		    		System.out.println("Invaid choice");
		    	}
		    
		    }
		}while(choice!=8);

	}

}
