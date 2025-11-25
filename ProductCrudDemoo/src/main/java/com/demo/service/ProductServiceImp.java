package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImp;

public class ProductServiceImp implements ProductService {
	private ProductDao pdao;
	
	public ProductServiceImp() {
		pdao = new ProductDaoImp();
	}

	@Override
	public List<Product> getAllProducts() {
		return pdao.showAllProducts();
	}

	@Override
	public Product getById(int pid) {
		return pdao.getById(pid);
	}

	@Override
	public boolean updateproduct(Product p) {
		return  pdao.updateProduct(p);
	}

	@Override
	public boolean deleteByIdProduct(int pid) {
		return pdao.deleteById(pid);
	}

	@Override
	public boolean addProdut(Product p) {
		return pdao.addProduct(p);
	}
}
