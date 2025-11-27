package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.demo.beans.Product;

public class ProductDaoImp implements ProductDao{
	static Connection conn;
	
	static {
		conn= DBUtil.getMyConnection();
	}

	@Override
	public List<Product> getAllProducts() {
		try {
			PreparedStatement selPro = conn.prepareStatement("select * from Product1");
			List<Product> plist = new ArrayList<>();
			ResultSet rs = selPro.executeQuery();
			
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6)));
			}
			return plist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
