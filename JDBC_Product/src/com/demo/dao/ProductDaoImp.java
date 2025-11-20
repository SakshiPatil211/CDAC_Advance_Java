package com.demo.dao;

import java.sql.*;
import java.util.List;
import java.util.*;

import com.demo.beans.Product;

public class ProductDaoImp implements ProductDao{
	static Connection conn;
	static PreparedStatement insertPro,displayPro,deletePro,updatePro,findPro, displaySorted;
	
	static {
		try {
			conn = DBUtil.getMyConnection();
			insertPro = conn.prepareStatement("insert into myproduct(pname,qty,price,mgdate) values(?,?,?,?)");
			displayPro = conn.prepareStatement("select * from myproduct");
			deletePro = conn.prepareStatement("delete from myproduct where pid = ?");
			updatePro = conn.prepareStatement("update myproduct set qty=?, price=? where pid=?");
			findPro = conn.prepareStatement("select * from myproduct where pid=?");
			displaySorted = conn.prepareStatement("select * from myproduct order by price");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean save(Product p) {
		try {
			insertPro.setString(1, p.getPname());
			insertPro.setInt(2, p.getQty());
			insertPro.setDouble(3, p.getPrice());
			insertPro.setDate(4, java.sql.Date.valueOf(p.getDate()));
			
			int n = insertPro.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> displayProduct() {
		List<Product> plist = new ArrayList<>();
		try {
			ResultSet rs = displayPro.executeQuery();
			
			while(rs.next()) {
				if(rs.getDate(5) != null) {
					plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate()));
				}else {
					plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),null));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return plist;
	}

	@Override
	public boolean deleteById(int id) {
		int n;
		
		try {
			deletePro.setInt(1, id);
			n = deletePro.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modifySalary(int id, int qty, double price) {
		try {
			updatePro.setInt(1, qty);
			updatePro.setDouble(2, price);
			updatePro.setInt(3, id);
			
			int n = updatePro.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Product findById(int id) {
		Product p= null;
		try {
			findPro.setInt(1, id);
			ResultSet rs = findPro.executeQuery();
			while(rs.next()) {
				if(rs.getDate(5)!=null) {
					p = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate());
				}else {
					p = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Product> displaySorted() {
		List<Product> plist = new ArrayList<>();
		
		try {
			ResultSet rs = displaySorted.executeQuery();
			
			while(rs.next()) {
				if(rs.getDate(5) != null) {
					plist.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4),rs.getDate(5).toLocalDate()));
				}else {
					plist.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4),null));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return plist;
	}
}