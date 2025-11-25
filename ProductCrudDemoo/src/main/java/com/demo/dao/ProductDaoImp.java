package com.demo.dao;

import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImp implements ProductDao{
	static Connection conn;
	static PreparedStatement selPro,getPid,updPro,delPro,inspro;
	
	static {	
		try {
			conn = DBUtil.getMyConnection();
			selPro = conn.prepareStatement("select * from Product1");
			getPid = conn.prepareStatement("select * from Product1 where pid=?");
			updPro = conn.prepareStatement("update Product1 set pname=?, qty=?, price=?,expdate=?,cid=? where pid=?");
			delPro = conn.prepareStatement("delete from Product1 where pid=?");
			inspro = conn.prepareStatement("insert into Product1 (pid,pname,qty,price,expdate,cid) values(?,?,?,?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> showAllProducts() {
		List<Product> plist = new ArrayList<>();
		try {
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

	@Override
	public Product getById(int pid) {
		Product p=null;
		try {
			getPid.setInt(1, pid);
			ResultSet rs = getPid.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateProduct(Product p) {
		try {
			updPro.setString(1, p.getPname());
			updPro.setInt(2, p.getQty());
			updPro.setDouble(3, p.getPrice());
			updPro.setDate(4, java.sql.Date.valueOf(p.getDate()));
			updPro.setInt(5, p.getCid());
			updPro.setInt(6, p.getPid());
			int n = updPro.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteById(int pid) {
		try {
			delPro.setInt(1, pid);
			int n = delPro.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addProduct(Product p) {
		try {
			inspro.setInt(1, p.getPid());
			inspro.setString(2, p.getPname());
			inspro.setInt(3, p.getQty());
			inspro.setDouble(4, p.getPrice());
			inspro.setDate(5, java.sql.Date.valueOf(p.getDate()));
			inspro.setInt(6, p.getCid());
			int n = inspro.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
