package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class TestCreateStatement {
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//step 1
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			//step 2
			String url = "jdbc:mysql://192.168.10.117:3306/dac71?useSSL=false";
			conn = DriverManager.getConnection(url,"dac71","welcome");
			
			if(conn != null) {
				System.out.println("Connection done");
			}else {
				System.out.println("Connection not done");
			}
			//step 3
			Statement st = conn.createStatement();
			
			//step 4
			ResultSet rs = st.executeQuery("select * from myproduct");
			
			while(rs.next()) {
				System.out.println("pid "+ rs.getInt(1));
				System.out.println("pname "+ rs.getString(2));
				System.out.println("qty "+ rs.getInt(3));
				System.out.println("price "+ rs.getDouble(4));
				System.out.println("date "+ rs.getDate(5));
				System.out.println("--------------------------------------");
			}
			String pname = "Pant";
			int qty = 50;
			double price = 1000.00;
			LocalDate ldate = LocalDate.now();
			String sqldate = ldate.toString();
			
			String query = "insert into myproduct(pname,qty,price,mgdate) values('"+pname+"', "+qty+","+price+",'"+sqldate+"')";
			int n = st.executeUpdate(query);
			if(n>0) {
				System.out.println("inserted successfully");
			}else {
				System.out.println("not inserted successfully");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				//step 5
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
