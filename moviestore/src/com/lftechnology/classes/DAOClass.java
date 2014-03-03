package com.lftechnology.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

/**
 * This class is used to access database. All the functions performing actions on database 
 * exist only in this class. This class extends class ConnectionManager, which creates 
 * persistent connection for all database functions.
 * @author nimesh
 *
 */
public class DAOClass extends ConnectionManager{
	private static final Logger LOG = Logger.getLogger(DAOClass.class
			.getName());
	private PreparedStatement prepared;
	private ResultSet resultSet;
	private Connection con;

	public DAOClass(){
		super();
		LOG.info("Into constructor of DAOClass");
		con=getConnection();
	}
	
	public boolean checkLogin(String userName,String password){
		boolean loggedin = false;
		
		return loggedin;
	}
}
