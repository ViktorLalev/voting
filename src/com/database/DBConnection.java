package com.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DBConnection implements Serializable {

	private final String db_url = "jdbc:mysql://localhost:3306/voting";
	private final String db_username = "root";
	private final String db_password = "";

	private Connection connection = null;
	protected PreparedStatement ps = null;

	protected ResultSet rs = null;

	public Connection connect() {
		try {
			DriverManager.registerDriver(new Driver());
			connection = DriverManager.getConnection(db_url, db_username, db_password);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	public void disconnect() {
		try {
			connection.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
