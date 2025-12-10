package com.demo.SpringBootRestful.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringBootRestful.beans.Product;
import com.demo.SpringBootRestful.dao.ProductDao;
import com.demo.SpringBootRestful.dto.ProductDto;
import com.demo.SpringBootRestful.mapper.ProductDtoMapper;

@Service
public class ProductServiceImp implements ProductService{
	@Autowired
	private ProductDao pdao;

	@Override
	public List<ProductDto> getAllProduct() {
		List<Product> plist = pdao.findAll();
		List<ProductDto> plist1 = plist.stream()
										.map(prod->ProductDtoMapper.mapToProductDto(prod))
										.collect(Collectors.toList());
		return plist1;
	}

	@Override
	public ProductDto getById(int pid) {
		Optional<Product> p = pdao.findById(pid);
		if(p.isPresent()) {
			ProductDto p1 = ProductDtoMapper.mapToProductDto(p.get());
			return p1;
		}
		return null;
	}
}
