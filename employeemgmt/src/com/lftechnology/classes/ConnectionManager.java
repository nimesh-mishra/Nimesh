package com.lftechnology.classes;

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
public class ConnectionManager {

	private static final Logger LOG = Logger.getLogger(ConnectionManager.class
			.getName());
	protected static Connection con;

	/**
	 * This is the constructor of the class ConnectionManager. This constructor
	 * loads the mysql driver. It also creates a database connection, which is
	 * later used by other classes to perform operations on the database.
	 * 
	 * @author nimesh
	 */
	public static Connection getConnection() {
		LOG.info("Into constructor of ConnectionManager class.");
		try {
			LOG.info("Loading Driver...");
			Class.forName("com.mysql.jdbc.Driver");
			LOG.info("Creating Database Connection");
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/ERP?"
							+ "user=root&password=nimesh");
			LOG.info("Connection created...");
		} catch (ClassNotFoundException | SQLException s) {
			LOG.log(Level.SEVERE,
					"SQLException occurred in ConnectionManager constructor.");
			LOG.log(Level.SEVERE, ". The message is : " + s.getMessage());
			closeConnection();
		}
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
						"Exception occurred @ ConnectionManager.closeConnection.");
				LOG.log(Level.SEVERE, "The message is : " + e.getMessage());
			}
		}
	}
}
