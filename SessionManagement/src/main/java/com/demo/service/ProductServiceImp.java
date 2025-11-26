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
	public List<Integer> getAllCategory() {
		return pdao.getAllCateory();
	}

	@Override
	public List<Product> getProductByCid(int cid) {
		return pdao.getProductByCid(cid);
	}
}
