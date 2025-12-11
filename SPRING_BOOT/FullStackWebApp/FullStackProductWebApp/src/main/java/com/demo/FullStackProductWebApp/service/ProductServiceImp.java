package com.demo.FullStackProductWebApp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.FullStackProductWebApp.dao.ProductDao;
import com.demo.FullStackProductWebApp.dto.ProductDto;
import com.demo.FullStackProductWebApp.beans.*;
import com.demo.FullStackProductWebApp.mapper.ProductDtoMapper;

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

	@Override
	public boolean addproduct(ProductDto p) {
		//convert ProductDto to Product
		Product prod=ProductDtoMapper.mapToProduct(p);
		Product p1=pdao.save(prod);
		return p1!=null;
	}

	@Override
	public boolean updateproduct(ProductDto p) {
		//convert ProductDto to Product
		Product prod=ProductDtoMapper.mapToProduct(p);
		Optional<Product> op=pdao.findById(prod.getPid());
		if(op.isPresent()) {
			Product p2=op.get();
			p2.setPname(p.getPname());
			p2.setQty(p.getQty());
			p2.setPrice(p.getPrice());
			pdao.save(p2);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteById(int pid) {
		Optional<Product> op=pdao.findById(pid);
		if(op.isPresent()) {
		   pdao.delete(op.get());
		   return true;
		}
		return false;
	}

	@Override
	public List<ProductDto> getByprice(double lprice, double hprice) {
		List<Product> plist=pdao.findByPrice(lprice,hprice);
		if(plist.size()>0) {
		List<ProductDto> plist1=plist.stream()
				.map(prod->ProductDtoMapper.mapToProductDto(prod))
				.collect(Collectors.toList());
		
			 return plist1;
		}
		return null;
	}
}
