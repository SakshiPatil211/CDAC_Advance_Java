package com.demo.SpringBootMVC.service;

import java.util.List;

import com.demo.SpringBootMVC.beans.Product;

public interface ProductService {

	List<Product> getAllProducts();

	void addProduct(Product p);

	Product getById(int pid);

	void updateProduct(Product product);

	void deleteProduct(int pid);

}
