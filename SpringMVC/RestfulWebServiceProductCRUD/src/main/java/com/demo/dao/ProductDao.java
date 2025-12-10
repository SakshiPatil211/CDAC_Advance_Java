package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dto.ProductDto;

public interface ProductDao {

	List<Product> getAllProduct();

	boolean addNewProduct(Product p);

	Product findProductById(int pid);

	boolean updateProduct(Product p);

	boolean deleteProductById(int pid);

}
