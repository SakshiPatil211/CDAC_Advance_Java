package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getById(int pid);

	boolean updateproduct(Product p);

	boolean deleteByIdProduct(int pid);

	boolean addProdut(Product p);

}
