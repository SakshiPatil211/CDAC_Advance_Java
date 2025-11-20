package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	boolean addNewProduct();

	List<Product> displayProduct();

	boolean deleteById(int id);

	boolean modifySalary(int id, int qty, double price);

	Product findById(int id);

	List<Product> displaySorted();

}
