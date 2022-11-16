package com.qa.automation.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public static Connection connection;
	
	@BeforeTest
	public Connection setConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/Emp";
		String username = "root";
		String password = "root";
		
		connection = DriverManager.getConnection(url,username,password);
		return connection;
	}
	
	@AfterTest
	public void tearDown() throws SQLException {
		connection.close();
	}
}
