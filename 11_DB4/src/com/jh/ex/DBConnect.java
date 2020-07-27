package com.jh.ex;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "root";
	private static String password = "admin";
	
	public static Connection getConnection() throws Exception {
		Class.forName(jdbcDriver);
		return DriverManager.getConnection(url, user, password);
	}
	
}
