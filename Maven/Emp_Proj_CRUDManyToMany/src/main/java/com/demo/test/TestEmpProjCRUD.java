package com.demo.test;
import java.util.Scanner;
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
		    System.out.println("6. exit");
		    System.out.println("Enter choice: ");
		    choice = sc.nextInt();
		    
		    switch(choice) {
		    	case 1->{
		    		pservice.addProject();
		    	}
		    	
		    	case 2->{
			    	
			    }
		    	
		    	case 3->{
			    	
			    }
		    	
		    	case 4->{
			    	
			    }
		    	
		    	case 5->{
			    	
			    }
		    	
		    	case 6->{
			    	System.out.println("Thanks for visiting");
			    }
		    	
		    	default->{
		    		System.out.println("Invaid choice");
		    	}
		    
		    }
		}while(choice!=6);

	}

}
