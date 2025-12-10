package com.demo.SpringBootRestful.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.SpringBootRestful.beans.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

}
