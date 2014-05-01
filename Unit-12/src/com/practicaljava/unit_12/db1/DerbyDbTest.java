package com.practicaljava.unit_12.db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyDbTest {
	private static String dbURL = "jdbc:derby://localhost:1527/test;create=true";

	public static void main(String[] args) {

		// Loads db driver
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");

		} catch (ClassNotFoundException e) {
			System.err.println("Can't load db driver: " + e.getMessage());
			System.exit(1);
		}

		// Connects to database
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbURL);
			
		} catch (SQLException e) {
			System.err.println("Can't connect to database: " + e.getMessage());
			System.exit(1);
		}

		// Selects from db
		try {
			Statement stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM employee");
			
			while (results.next()) {
				int emplId = results.getInt("empl_id");
				String name = results.getString("name");
				String job = results.getString("job_title");

				System.out.println(emplId + ", " + name + ", " + job);
			}
			
		} catch (SQLException e) {
			System.err.println("Error of execution SQL statement: " + e.getMessage());
			//System.exit(1);
		}

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("[programm passed]");
	}
}
