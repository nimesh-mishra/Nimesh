package com.lftechnology.employee.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is used to store connection to the database, ERP
 * @author nimesh
 *
 */
public class DbUtils {
	private static final Logger LOG = Logger.getLogger(DbUtils.class
			.getName());
	protected static Connection con;
	/**
	 * This is the constructor of the class DbUtils. This constructor
	 * loads the mysql driver. It also creates a database connection, which is
	 * later used by other classes to perform operations on the database.
	 * 
	 * @author nimesh
	 */
	public static Connection getConnection() {
		LOG.info("Into constructor of DbUtils class.");
		try {
			LOG.info("Loading Driver...");
			Class.forName("com.mysql.jdbc.Driver");
			LOG.info("Creating Database Connection");
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/ERP?"
							+ "user=root&password=nimesh");
			con.setAutoCommit(false);
			LOG.info("Connection created...");
		} catch (ClassNotFoundException | SQLException s) {
			LOG.log(Level.SEVERE,
					"SQLException occurred in DbUtils constructor.");
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
						"Exception occurred @ DbUtils.closeConnection.");
				LOG.log(Level.SEVERE, "The message is : " + e.getMessage());
			}
		}
	}
}
