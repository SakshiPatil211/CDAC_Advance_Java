package com.demo.SpringBootMVC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringBootMVC.beans.Product;
import com.demo.SpringBootMVC.dao.ProductDao;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	ProductDao pdao;

	@Override
	public List<Product> getAllProducts() {
		return pdao.findAll();
	}

	@Override
	public void addProduct(Product p) {
		pdao.save(p);
	}

	@Override
	public Product getById(int pid) {
		Optional<Product> p = pdao.findById(pid);
		if(p.isPresent()) {
			return p.get();
		} else {
			return null;
		}
	}

	@Override
	public void updateProduct(Product product) {
		Optional<Product> p = pdao.findById(product.getPid());
		if(p.isPresent()) {
			Product p1 = p.get();
			p1.setPname(product.getPname());
			p1.setQty(product.getQty());
			p1.setPrice(product.getPrice());
			p1.setMfgdate(product.getMfgdate());
			pdao.save(p1);
		}
	}

	@Override
	public void deleteProduct(int pid) {
		Optional<Product> p = pdao.findById(pid);
		if(p.isPresent()) {
			Product p1 = p.get();
			pdao.delete(p1);
		}
	}
}
