package com.demo.SpringBootRestful.service;

import java.util.List;

import com.demo.SpringBootRestful.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getAllProduct();

	ProductDto getById(int pid);

}
