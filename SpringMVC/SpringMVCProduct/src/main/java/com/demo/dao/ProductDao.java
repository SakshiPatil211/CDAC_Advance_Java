package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> getAllProduct();

	boolean addNewProduct(Product p);

	Product getProductById(int pid);

	boolean updateProduct(Product p);

	boolean deleteProductById(int pid);

}
