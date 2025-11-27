package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImp;

public class ProductServiceImp implements ProductService{
	private ProductDao pdao;
	
	public ProductServiceImp() {
		pdao = new ProductDaoImp();
	}

	@Override
	public List<Product> getAllProduct() {
		return pdao.getAllProducts();
	}
}
