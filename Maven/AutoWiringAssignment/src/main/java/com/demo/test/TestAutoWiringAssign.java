package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Student;

public class TestAutoWiringAssign {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		Student s = (Student) ctx.getBean("stud");
		
		System.out.println(s);
		((ClassPathXmlApplicationContext) ctx).close();
	}
}
