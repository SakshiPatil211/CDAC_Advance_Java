package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getAllProduct();

	boolean addProduct(ProductDto p);

	ProductDto getProductById(int pid);

	boolean updateProduct(ProductDto p);

	boolean deleteProductById(int pid);

}
