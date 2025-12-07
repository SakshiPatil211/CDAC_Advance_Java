package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Product;
import com.demo.beans.User;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService pservice;
	
	@GetMapping("/showproduct")
	public ModelAndView getAllProducts(HttpSession session) {
		User u = (User) session.getAttribute("user");
		if(u!=null && u.getRole().equals("user")) {
			List<Product> plist = pservice.getAllProduct();
			return new ModelAndView("showproduct","plist",plist);
		}else {
			return new ModelAndView("loginpage","message","Invalid credentials");
		}
	}
	
	@GetMapping("/addproduct")
	public String addProduct(Model mymodel) {
		mymodel.addAttribute("p1",new Product());
		return "insertproduct";
	}
	
	@PostMapping("/insertproductintable")
	public ModelAndView showProdTable(@ModelAttribute Product p) {
		System.out.println(p);
		boolean status = pservice.addProduct(p);
		return new ModelAndView("redirect:/product/showproduct");
	}
	
	@GetMapping("/editproduct/{pid}")
	public ModelAndView editProduct(@PathVariable("pid") int pid) {
		Product p = pservice.getProductById(pid);
		if(p!=null) {
			return new ModelAndView("editproduct","prod",p);
		}else {
			return new ModelAndView("redirect:product/showproduct");
		}
	}
	
	@PostMapping("/updateproduct")
	public ModelAndView updateProduct(@ModelAttribute Product p) {
		System.out.println(p);
		boolean status = pservice.updateProduct(p);
		return new ModelAndView("redirect:/product/showproduct");
	}
	
	@GetMapping("/deleteproduct/{pid}")
	public ModelAndView deleteProduct(@PathVariable("pid") int pid) {
		boolean status = pservice.deleteProductById(pid);
		return new ModelAndView("redirect:/product/showproduct");
	}
}
