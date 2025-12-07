package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProduct();

	boolean addProduct(Product p);

	Product getProductById(int pid);

	boolean updateProduct(Product p);

	boolean deleteProductById(int pid);

}
