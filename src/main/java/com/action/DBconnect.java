package com.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBconnect {
	private static final String DATABASE_DRIVE = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://jwetqdmftbkp.rds.sae.sina.com.cn:10385/BookDB";
	private static final String USERNAME = "root";;
	private static final String PASSWORD = "123456";

	// init connection object
	private Connection connection;
	// init properties object
	private Properties properties;

	// create properties
	private Properties getProperties() {
		if (properties == null) {
			properties = new Properties();
			properties.setProperty("user", USERNAME);
			properties.setProperty("password", PASSWORD);
		}
		return properties;
	}

	// connect database
	public Connection connect() {
		if (connection == null) {
			try {
				Class.forName(DATABASE_DRIVE).newInstance();
				connection = DriverManager.getConnection(DATABASE_URL, getProperties());
			} catch (Exception e) {
				// Java 7+
				e.printStackTrace();
			}
		}
		return connection;
	}

	// disconnect database
	public void disconnect() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
