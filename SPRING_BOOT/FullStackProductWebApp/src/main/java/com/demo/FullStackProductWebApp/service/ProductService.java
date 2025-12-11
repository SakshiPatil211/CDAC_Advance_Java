package com.demo.FullStackProductWebApp.service;

import java.util.List;

import com.demo.FullStackProductWebApp.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getAllProduct();

	ProductDto getById(int pid);

	boolean addproduct(ProductDto p);

	boolean updateproduct(ProductDto p);

	boolean deleteById(int pid);

	List<ProductDto> getByprice(double lprice, double hprice);

}
