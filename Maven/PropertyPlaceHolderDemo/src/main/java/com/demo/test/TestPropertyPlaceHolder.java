package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.MyUser;

public class TestPropertyPlaceHolder {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		MyUser u = (MyUser) ctx.getBean("u1");
		((ClassPathXmlApplicationContext)ctx).close();
		System.out.println(u);
	}
}
