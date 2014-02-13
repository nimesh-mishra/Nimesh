package com.lftechnology.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is used to store connection to the database, LfDatabaseTraining
 * 
 * @author nimesh
 * 
 */
public class DatabaseConnection {
	private static final Logger LOG = Logger.getLogger(DatabaseConnection.class
			.getName());
	protected static Connection con;

	/**
	 * This is the constructor of the class DatabaseConnection. This constructor
	 * loads the mysql driver. It also creates a database connection, which is
	 * later used by other classes to perform operations on the database.
	 * 
	 * @author nimesh
	 */
	public DatabaseConnection() {
		LOG.info("Into constructor of DatabaseConnection class.");
		try {
			LOG.info("Loading Driver...");
			Class.forName("com.mysql.jdbc.Driver");
			LOG.info("Creating Database Connection");
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/LfDatabaseTraining?"
							+ "user=root&password=nimesh");
		} catch (ClassNotFoundException | SQLException s) {
			LOG.log(Level.SEVERE,
					"SQLException occurred in DatabaseConnection constructor.");
			LOG.log(Level.SEVERE, ". The message is : " + s.getMessage());
			closeConnection();
		}

	}

	/**
	 * This method is used to access the Connection Object created by
	 * {@link DatabaseConnection} Constructor.
	 * 
	 * @return {@link Connection} The connection object used to create
	 *         connection to the database.
	 * @author nimesh
	 */
	protected static Connection getConnection() {
		return con;
	}

	/**
	 * This method is used to close the connection made to the database.
	 * 
	 * @author nimesh
	 */
	protected static void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				LOG.log(Level.SEVERE,
						"Exception occurred @ DatabaseConnection.closeConnection.");
				LOG.log(Level.SEVERE, "The message is : " + e.getMessage());
			}
		}
	}
}
