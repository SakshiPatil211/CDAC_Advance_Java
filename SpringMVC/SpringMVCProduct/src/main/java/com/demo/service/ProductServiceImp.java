package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImp implements ProductService{
	@Autowired
	ProductDao pdao;

	public List<Product> getAllProduct() {
		return pdao.getAllProduct();
	}

	@Override
	public boolean addProduct(Product p) {
		return pdao.addNewProduct(p);
	}

	@Override
	public Product getProductById(int pid) {
		return pdao.getProductById(pid);
	}

	@Override
	public boolean updateProduct(Product p) {
		return pdao.updateProduct(p);
	}

	@Override
	public boolean deleteProductById(int pid) {
		return pdao.deleteProductById(pid);
	}
}
