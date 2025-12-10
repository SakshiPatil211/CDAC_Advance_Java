package com.demo.SpringBootRestful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.demo.SpringBootRestful.dto.ProductDto;
import com.demo.SpringBootRestful.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> plist = pservice.getAllProduct();
		return ResponseEntity.ok(plist);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/products/{pid}")
	public ResponseEntity<ProductDto> getById(@PathVariable int pid){
		ProductDto p = pservice.getById(pid);
		if(p!=null) {
			return ResponseEntity.ok(p);
		}else {
			return (ResponseEntity<ProductDto>) ResponseEntity.notFound();
		}
	}
}
