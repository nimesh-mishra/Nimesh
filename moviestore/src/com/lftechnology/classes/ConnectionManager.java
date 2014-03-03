package com.lftechnology.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is used to create database connection. This class keeps the 
 * database connection alive for all users.
 * @author nimesh
 *
 */
public class ConnectionManager {
	private static final Logger LOG = Logger.getLogger(ConnectionManager.class
			.getName());
	protected static Connection con;
	
		public ConnectionManager(){
			LOG.info("Into constructor of ConnectionManager class.");
			try {
				LOG.info("Loading Driver...");
				Class.forName("com.mysql.jdbc.Driver");
				LOG.info("Creating Database Connection");
				con = DriverManager
						.getConnection("jdbc:mysql://localhost/moviedb?"
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
		 * {@link ConnectionManager} Constructor.
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
