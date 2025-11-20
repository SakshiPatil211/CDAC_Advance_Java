package com.demo.test;
import java.util.*;

import com.demo.service.*;
import com.demo.beans.*;

public class TestProductManagement {

	public static void main(String[] args) {
		ProductService pservice = new ProductServiceImp();
		Scanner sc = new Scanner(System.in);
		
		int choice=0;
		do {
			System.out.println("1. add new product\n2. delete product\n3. modify product");
			System.out.println("4.find by Id\n5. display all\n6. display in sorted order\n7. exit");
			System.out.println("Enter choice :");
			choice=sc.nextInt();
			switch(choice) {
				case 1->{
					boolean status=pservice.addNewProduct();
					if(status) {
						System.out.println("product addedd successfully");
					}else {
						System.out.println("Not added");
					}
				}
				
				case 2->{
					System.out.println("Enter the product id");
					int id = sc.nextInt();
					boolean status = pservice.deleteById(id);
					if(status) {
						System.out.println("deleted successfully");
					}else {
						System.out.println("not found");
					}
				}
				
				case 3->{
					System.out.println("Enter the id");
					int id = sc.nextInt();
					System.out.println("Enter the quantity");
					int qty = sc.nextInt();
					System.out.println("Enter the price");
					double price = sc.nextDouble();
					
					boolean status = pservice.modifySalary(id,qty,price);
					if(status){
						System.out.println("modified successfully");
					}else {
						System.out.println("not found");
					}
				}
				
				case 4->{
					System.out.println("Enter the id");
					int id = sc.nextInt();
					Product p = pservice.findById(id);
					if(p!=null) {
						System.out.println(p);
					}else {
						System.out.println("not found");
					}
				}
			
				case 5->{
					List<Product> plist = pservice.displayProduct();
				
					if(plist.size() > 0) {
						plist.forEach(System.out::println);				
					}else {
						System.out.println("list is empty");
					}
				}
				
				case 6->{
					List<Product> plist = pservice.displaySorted();
					
					if(plist.size() > 0) {
						plist.forEach(System.out::println);				
					}else {
						System.out.println("list is empty");
					}
				}
			
				case 7->{
					System.out.println("Thank you for visiting .....");
					sc.close();
				}
			}
		}while(choice!=7);
	}

}
