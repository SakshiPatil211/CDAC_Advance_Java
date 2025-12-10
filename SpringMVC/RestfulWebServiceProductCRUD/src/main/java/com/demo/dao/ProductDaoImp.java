package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImp implements ProductDao{
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Product> getAllProduct() {
		@SuppressWarnings("deprecation")
		List<Product> plist = jdbcTemplate.query("select * from product",(rs,numrow)->{
			Product p = new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			p.setMfgdate(rs.getDate(5).toLocalDate());
			p.setCid(rs.getInt(6));
			return p;
		});
		return plist;
	}

	public boolean addNewProduct(Product p) {
		int n = jdbcTemplate.update("insert into product values(?,?,?,?,?,?)",new Object[]{
			p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getMfgdate(),p.getCid()
		});
		return n>0;
	}

	public Product findProductById(int pid) {
		try {
			@SuppressWarnings("deprecation")
			Product p = jdbcTemplate.queryForObject("select * from product where pid=?", 
					new Object[] {pid} ,BeanPropertyRowMapper.newInstance(Product.class));
			return p;
		}catch(EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	public boolean updateProduct(Product p) {
		int n = jdbcTemplate.update("update product set pname=?, qty=?,price=? where pid=?",
				new Object[] {p.getPname(),p.getQty(),p.getPrice(),p.getPid()});
		return n>0;
	}

	public boolean deleteProductById(int pid) {
		int n = jdbcTemplate.update("delete from product where pid=?",new Object[] {pid});
		return n>0;
	}
	
}
