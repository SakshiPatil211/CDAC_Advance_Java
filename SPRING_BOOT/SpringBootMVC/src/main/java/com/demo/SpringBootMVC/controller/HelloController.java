package com.demo.SpringBootMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@GetMapping("/helloo")
	public ModelAndView sayHello() {
		String msg = "Hello to the world!!!!!";
		return new ModelAndView("hello","message",msg);
	}
	
	
}
