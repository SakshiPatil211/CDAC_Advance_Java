package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.Users;

public class LoginDaoImp implements LoginDao{
	static Connection conn=null;
	
	static {
		conn = DBUtil.getMyConnection();
	}

	@Override
	public Users checkUser(String uname, String pass) {
		try {
			PreparedStatement ucheck = conn.prepareStatement("select uid,uname,email,role from users where uname=? and password=?");
			ucheck.setString(1, uname);
			ucheck.setString(2, pass);
			ResultSet rs = ucheck.executeQuery();
			if(rs.next()) {
				Users u = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
