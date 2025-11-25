package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.Users;

public class LoginDaoImp implements LoginDao {
	static Connection conn = null;
	static PreparedStatement seluser;
	
	static {
		try {
			conn = DBUtil.getMyConnection();
			seluser = conn.prepareStatement("select uid, uname, email, role from users where uname=? and password=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Users checkUser(String uname, String pass) {
		try {
			seluser.setString(1, uname);
			seluser.setString(2, pass);
			ResultSet rs = seluser.executeQuery();
			
			if(rs.next()) {
				Users user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
