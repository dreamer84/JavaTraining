package com.practicaljava.unit_12.db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The program for practice with a relational database using the DriverManager
 * class for connection to it. This version uses a precompiled SQL statement
 * (PreparedStatement).
 *
 * @version 3
 */
public class DerbyDbTest3 {
	private static String dbURL = "jdbc:derby://localhost:1527/db1b;create=true";

	// The prepared statement with the 'job_title' as a variable parameter
	private static String emplByJobQuery = "SELECT employees.name, employees.job_title"
				+ " FROM employees WHERE job_title=?";

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			runTest();

		} catch (SQLException sqlEx) {
			// Shows every exception in the chain.
			for (Throwable t : sqlEx) {
				t.printStackTrace();
			}
		}

		System.out.println("[program passed]");
	}

	/**
	 * Runs a test creating a table, inserting values, selecting and showing
	 * them, and droping the table.
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void runTest() throws ClassNotFoundException, SQLException {
		try (Connection conn = getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				// Deletes the table if it exists
				stmt.executeUpdate("DROP TABLE employees");
				// Creates a new table and populates it with the values
				stmt.executeUpdate("CREATE TABLE employees "
						+ "(empl_id INT NOT NULL, name VARCHAR(50) NOT NULL,"
						+ " job_title VARCHAR(150))");
				stmt.executeUpdate("INSERT INTO employees VALUES "
						+ "(1212, 'Ivan Petrov', 'Manager'),"
						+ "(1213, 'Denis Ivanov', 'Developer'),"
						+ "(1214, 'John Smith', 'Counter'),"
						+ "(1215, 'John Doe', 'Developer'),"
						+ "(1216, 'Anonymous', 'Developer')");

				try (PreparedStatement prStmt = conn
						.prepareStatement(emplByJobQuery)) {
					// Selects from the DB
					prStmt.setString(1, "Developer");
					ResultSet results = prStmt.executeQuery();

					while (results.next()) {
						String name = results.getString("name");
						String job = results.getString("job_title");

						System.out.println(name + ", " + job);
					}
				}
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
	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		// Loads the database driver
		Class.forName("org.apache.derby.jdbc.ClientDriver");

		// Connects to the DB and returns the connection
		return DriverManager.getConnection(dbURL);
	}
}
