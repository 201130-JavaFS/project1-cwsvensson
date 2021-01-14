package com.rev_cws.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException {
		// For compatibility with other technologies/frameworks will
		// need to register our Driver

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

			// Replaced localhost with the AWS endpoint  then change shield with postgres
		
		//String url = "jdbc:postgresql://localhost:5432/reimbursement";
		String url = "jdbc:postgresql://javafs201130.chtpcni0nkep.us-east-2.rds.amazonaws.com:5432/postgres";

//		String username = "postgres";
//		String password = "--------";  // password removed for security reasons
		String username = System.getenv("postgreSQLusername");
		//String password = System.getenv("postgreSQLpassword");
		String password = "postgres";
		
		return DriverManager.getConnection(url, username, password);
	}

	public static void main(String[] args) {

		// Try with resources block. The try statement will stake a method that creates
		// a resource, that will automatically be closed at the end of the try or catch
	    // block. It avoids the need for a finally block.
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("connection successful");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}