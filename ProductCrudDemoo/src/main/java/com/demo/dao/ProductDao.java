package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> showAllProducts();

	Product getById(int pid);

	boolean updateProduct(Product p);

	boolean deleteById(int pid);

	boolean addProduct(Product p);

}
