package com.wegneto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String password = "root";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection successful.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
