package com.revature.util;
import java.io.*;
import java.sql.*;
import java.util.Properties;


public class ConnectionUtil {
	public static Connection getConnection() throws SQLException, IOException {
		FileInputStream input = new FileInputStream("");
		Properties prop = new Properties();
		InputStream in = new FileInputStream("connection.properties");
		prop.load(in);
		
		String url = prop.getProperty("");
		String user = prop.getProperty("");
		String password = prop.getProperty("");
		
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		return DriverManager.getConnection(url, user, password);
	}
}