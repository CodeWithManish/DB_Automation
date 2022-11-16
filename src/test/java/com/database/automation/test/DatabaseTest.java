package com.database.automation.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;
import com.qa.automation.base.BaseClass;

public class DatabaseTest extends BaseClass {
	
	PreparedStatement preparedStatement = null;

	@Test
	public void toFetchData() throws SQLException {
		String query = "select * from employee";
		connection = this.setConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			String myName = resultSet.getString(1);
			String myAge = resultSet.getString(2);
			System.out.println(myName + " " + myAge);
		}
	}

	@Test
	public void toInsertData() throws SQLException {
		String query = "insert into employee (name, age) values(?,?)";
		connection = this.setConnection();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, "Ram");
		preparedStatement.setInt(2, 26);
		preparedStatement.executeUpdate();
	}

	@Test
	public void toDeleteData() throws SQLException {
		String query = "delete from employee where Name =?";
		connection = this.setConnection();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, "Diksha");
		preparedStatement.executeUpdate();
		
	}
	
	@Test
	public void toUpdateData() throws SQLException {
		String query = "update employee set Name =? where Age =?";
		connection = this.setConnection();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, "Awantika");
		preparedStatement.setInt(2, 26);
		preparedStatement.executeUpdate();
	}

	
}
