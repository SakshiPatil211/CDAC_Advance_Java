package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.demo.beans.Users;

public class RegistrationDaoImp implements RegistrationDao{
	static Connection conn;
	static PreparedStatement insUser;
	
	static{
		try {
			conn = DBUtil.getMyConnection();
			insUser = conn.prepareStatement("insert into users (uid,uname,password,email,role) values(?,?,?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int store(int uid,String uname,String email,String pass) {
		Users u = new Users();
		try {
			insUser.setInt(1, uid);
			insUser.setString(2, uname);
			insUser.setString(3, pass);
			insUser.setString(4, email);
			insUser.setString(5, u.getRole());
			
			int n = insUser.executeUpdate();
			return n;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
