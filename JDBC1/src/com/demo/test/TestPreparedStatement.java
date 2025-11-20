package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.*;

public class TestPreparedStatement {

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
			
			String query = "select * from myproduct";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				System.out.println("pid "+ rs.getInt(1));
				System.out.println("pname "+ rs.getString(2));
				System.out.println("qty "+ rs.getInt(3));
				System.out.println("price "+ rs.getDouble(4));
				System.out.println("date "+ rs.getDate(5));
				System.out.println("--------------------------------------");
			}
			
			String pname = "Trouser";
			int qty = 60;
			double price = 2000.00;
			LocalDate ldate = LocalDate.now();
			//String sqldate = ldate.toString();
			
			String query1 = "insert into myproduct(pname,qty,price,mgdate) values(?,?,?,?)";
			PreparedStatement pst1 = conn.prepareStatement(query1);
			pst1.setString(1,pname);
			pst1.setInt(2, qty);
			pst1.setDouble(3, price);
			pst1.setDate(4, java.sql.Date.valueOf(ldate));
			
			int n = pst1.executeUpdate();
			if(n>0) {
				System.out.println("Inserted successfully");
			}else {
				System.out.println("not inserted");
			}
			
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