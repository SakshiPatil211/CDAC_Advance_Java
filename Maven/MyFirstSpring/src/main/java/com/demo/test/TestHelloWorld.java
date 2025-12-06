package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Employee;
import com.demo.beans.HelloWorld;
import com.demo.beans.MyUser;

public class TestHelloWorld {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		
		HelloWorld hwbean = (HelloWorld) ctx.getBean("hw");
		String str = hwbean.showHello();
		System.out.println(str);
		
		Employee e1 = (Employee) ctx.getBean("emp1");
		System.out.println(e1);
		
		Employee e2 = (Employee) ctx.getBean("emp2");
		System.out.println(e2);
		
		Employee e3 = (Employee) ctx.getBean("emp3");
		System.out.println(e3);
		
		MyUser u = (MyUser) ctx.getBean("u1");
		System.out.println(u);

		((AbstractApplicationContext) ctx).close();
		
	}

}
