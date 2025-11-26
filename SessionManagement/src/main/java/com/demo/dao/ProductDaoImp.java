package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.demo.beans.Product;

import java.util.*;

public class ProductDaoImp implements ProductDao{
	static Connection conn;
	
	static {
		if(conn == null) {
			conn = DBUtil.getMyConnection();
		}	
	}

	@Override
	public List<Integer> getAllCateory() {
		try {
			PreparedStatement selcid = conn.prepareStatement("select cid from Product1");
			ResultSet rs = selcid.executeQuery();
			List<Integer> clist = new ArrayList<>();
			while(rs.next()) {
				clist.add(rs.getInt(1));
			}
			return clist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getProductByCid(int cid) {
		try {
			PreparedStatement getpro = conn.prepareStatement("select * from Product1 where cid=?");
			getpro.setInt(1, cid);
			ResultSet rs = getpro.executeQuery();
			List<Product> plist = new ArrayList<>();
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
