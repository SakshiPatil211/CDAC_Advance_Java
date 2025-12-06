package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;
import java.util.*;

public class TestResourceBuilding {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
        MessageSource ms=(MessageSource)ctx.getBean(ResourceBundleMessageSource.class);
        
        System.out.println("1. Marathi\n 2. US English\n 3. UK English\n 4. Others\n");
        System.out.println("Enter the choice");
        
        int choice = sc.nextInt();
        Locale local = null;
        
        switch(choice){
        	case 1->{
        		local = new Locale("my","marathi");
        		System.out.println("Country "+ local.getCountry());
        		System.out.println("Language "+ local.getLanguage());
        	}
        	
        	case 2->{
        		local = Locale.US;
        		System.out.println("Country "+ local.getCountry());
        		System.out.println("Language "+ local.getLanguage());
        	}
        	
        	case 3->{
        		local = Locale.UK;
        		System.out.println("Country "+ local.getCountry());
        		System.out.println("Language "+ local.getLanguage());
        	}
   
        }
        
        
        String msg1 = ms.getMessage("msg.pay",null,local);
        String msg2 = ms.getMessage("msg.welcome",new Object[] {"Sakshi"},local);
        String msg3 = ms.getMessage("msg.billmsg",null,local);
        String msg4 = ms.getMessage("msg.currancy",null,local);
        
        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println(msg3);
        System.out.println(msg4);   
	}
}
