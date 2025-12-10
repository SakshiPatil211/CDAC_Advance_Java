package com.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dto.ProductDto;
import com.demo.mapper.ProductDtoMapper;

@Service
public class ProductServiceImp implements ProductService{
	@Autowired
	ProductDao pdao;

	public List<ProductDto> getAllProduct() {
		List<Product> plist = pdao.getAllProduct();
		List<ProductDto> plist1 = plist.stream()
										.map(prod->ProductDtoMapper.mapToProductDto(prod))
										.collect(Collectors.toList());
		return plist1;
	}

	public boolean addProduct(ProductDto prod) {
		Product p = ProductDtoMapper.mapToProduct(prod);
		return pdao.addNewProduct(p);
	}

	public ProductDto getProductById(int pid) {
		Product p = pdao.findProductById(pid);
		ProductDto prod = ProductDtoMapper.mapToProductDto(p);
		return prod;
	}

	public boolean updateProduct(ProductDto prod) {
		Product p = ProductDtoMapper.mapToProduct(prod);
		return pdao.updateProduct(p);
	}

	public boolean deleteProductById(int pid) {
		return pdao.deleteProductById(pid);
	}

}
