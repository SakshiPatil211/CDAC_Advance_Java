package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ForgotPasswordDaoImp implements ForgotPasswordDao {
	static Connection conn = null;
	static PreparedStatement updatepass;
	
	static {
		try {
			conn = DBUtil.getMyConnection();
			updatepass = conn.prepareStatement("update users set password=? where uname=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int resetPass(String uname, String pass) {
		try {
			updatepass.setString(1, pass);
			updatepass.setString(2, uname);
			int n = updatepass.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
