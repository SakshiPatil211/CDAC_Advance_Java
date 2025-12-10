package com.demo.SpringBootMVC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.SpringBootMVC.beans.Product;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{
	
}
