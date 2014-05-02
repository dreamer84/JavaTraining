package com.practicaljava.unit_12.db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The program for practice with a relational database
 * using the DriverManager class for connection to it.
 * This version divides code to convenient methods.
 * @version 2
 */
public class DerbyDbTest2 {
	private static String dbURL = "jdbc:derby://localhost:1527/db1a;create=true";

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			runTest();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("[program passed]");
	}

	/**
	 * Runs a test creating a table, inserting values, selecting
	 * and showing them, and droping the table.
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void runTest() throws ClassNotFoundException, SQLException {
		try (Connection conn = getConnection()) {
			// * When a Statement object is closed, its current ResultSet object,
			// if one exists, is also closed.
			try (Statement stmt = conn.createStatement()) {
				stmt.executeUpdate("CREATE TABLE employees (empl_id INT NOT NULL, name varchar(50) NOT NULL, job_title varchar(150))");
				stmt.executeUpdate("INSERT INTO employees VALUES (1212, 'Ivan Petrov', 'Manager'), (1213, 'Denis Ivanov', 'Developer'), (1214, 'John Smith', 'Counter')");

				// Selects from the DB
				ResultSet results = stmt.executeQuery("SELECT * FROM employees");

				while (results.next()) {
					int emplId = results.getInt("empl_id");
					String name = results.getString("name");
					String job = results.getString("job_title");

					System.out.println(emplId + ", " + name + ", " + job);
				}

				stmt.executeUpdate("DROP TABLE employees");
			}
		}
	}

	/**
	 * Gets a connection to the database
	 *
	 * @return the database connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// Loads the database driver
		Class.forName("org.apache.derby.jdbc.ClientDriver");

		// Connects to the DB and returns the connection
		return DriverManager.getConnection(dbURL);
	}
}
