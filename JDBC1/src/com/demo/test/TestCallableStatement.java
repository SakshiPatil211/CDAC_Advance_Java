package com.demo.test;

import java.sql.*;

public class TestCallableStatement {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			String url = "jdbc:mysql://192.168.10.117:3306/dac71?useSSL=false";
			conn = DriverManager.getConnection(url,"dac71","welcome");
			
			if(conn!=null) {
				System.out.println("Connection successful");
			}else {
				System.out.println("Connection not successful");
			}
			
			CallableStatement cst = conn.prepareCall("call getcount(?,?)");
			//in parameter
			cst.setString(1, "Shirt");
			//out parameter
			cst.registerOutParameter(2, java.sql.Types.INTEGER); // data type in sql to store data in int
			
			cst.execute();
			int cnt = cst.getInt(2);
			System.out.println("Count " + cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}