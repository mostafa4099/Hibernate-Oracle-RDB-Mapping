package com.mostafa.sna.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@10.11.201.251:1521:stlbas";
		String user = "hr";
		String pass = "hr";
		
		try {
			
			System.out.println("DBConnecting......");
			
			Connection con = DriverManager.getConnection(url, user, pass);
			
			System.out.println("DB Connected "+con.getSchema());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

	}

}
