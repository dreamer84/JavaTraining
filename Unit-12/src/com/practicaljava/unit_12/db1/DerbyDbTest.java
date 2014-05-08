package com.practicaljava.unit_12.db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The program for practice with a relational database
 * using the DriverManager class for connection to it.
 */
public class DerbyDbTest {
	// The database "db1" must exists!
	private static String dbURL = "jdbc:derby://localhost:1527/db1";

	public static void main(String[] args) {
		// Loads the database driver
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");

		} catch (ClassNotFoundException e) {
			System.err.println("Can't load db driver: " + e.getMessage());
			System.exit(1);
		}

		// Connects to the DB
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbURL);

		} catch (SQLException e) {
			System.err.println("Can't connect to database: " + e.getMessage());
			System.exit(1);
		}

		// Selects from the DB
		try {
			Statement stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM employees");

			while (results.next()) {
				int emplId = results.getInt("empl_id");
				String name = results.getString("name");
				String job = results.getString("job_title");

				System.out.println(emplId + ", " + name + ", " + job);
			}

			// * When a Statement object is closed, its current ResultSet object,
			// if one exists, is also closed.
			stmt.close();

		} catch (SQLException e) {
			System.err.println("Error of execution SQL statement: " + e.getMessage());
		}

		try {
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("[program passed]");
	}
}
