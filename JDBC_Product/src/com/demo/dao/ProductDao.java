package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	boolean save(Product p);

	List<Product> displayProduct();

	boolean deleteById(int id);

	boolean modifySalary(int id, int qty, double price);

	Product findById(int id);

	List<Product> displaySorted();

}
