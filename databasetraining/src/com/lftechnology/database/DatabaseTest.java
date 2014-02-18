package com.lftechnology.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class connects to mysql database and performs insertions,queries and
 * delete operations.
 * 
 * @author nimesh
 */
public class DatabaseTest extends DatabaseConnection {
	private static final Logger LOG = Logger.getLogger(DatabaseTest.class
			.getName());
	private PreparedStatement prepared;
	private ResultSet resultSet;
	private Connection con;

	/**
	 * This is default constructor. This constructor calls the constructor of
	 * class {@link DatabaseConnection} which in turn loads the mysql driver for
	 * java. It also initializes {@link Connection} object for this class.
	 * 
	 * @author nimesh
	 */

	public DatabaseTest() {
		super();
		LOG.info("Into DatabaseTest constructor");
		con = getConnection();
	}

	/**
	 * This method inserts new employee data into table
	 * LfDatabaseTraining.employees
	 * 
	 * @param name
	 *            {@link String} The name of employee to be added..
	 * @author nimesh
	 */
	private void insertIntoTableEmployees(String name) {
		LOG.info("Into method insertIntoTableEmployees");
		LOG.log(Level.FINE, "The name to insert is : " + name);
		try {
			prepared = con
					.prepareStatement("insert into LfDatabaseTraining.employees values (default,?)");
			prepared.setString(1, name);
			int i = prepared.executeUpdate();
			if (i == 0) {
				LOG.log(Level.SEVERE,
						"Sorry error occurred while inserting data");
			} else {
				LOG.info("Inserted data successfully");
			}
		} catch (SQLException e) {
			LOG.log(Level.SEVERE,
					"Exception occurred at insertIntoTableEmployees. ");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}
	}

	/**
	 * This method inserts new employee data into table
	 * LfDatabaseTraining.salary
	 * 
	 * @param salary
	 *            {@link Float} The salary to be inserted.
	 * @author nimesh
	 */
	private void insertIntoTableSalary(float salary) {
		LOG.info("Into method insertIntoTableSalary");
		LOG.log(Level.FINE, "The salary to insert is : " + salary);
		try {
			prepared = con
					.prepareStatement("insert into LfDatabaseTraining.salary values (default,?)");
			prepared.setFloat(1, salary);
			int i = prepared.executeUpdate();
			if (i == 0) {
				LOG.log(Level.SEVERE,
						"Sorry error occurred while inserting data");
			} else {
				LOG.info("Inserted data successfully");
			}
		} catch (SQLException e) {
			LOG.log(Level.SEVERE,
					"Exception occurred @ insertIntoTableSalary. ");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}
	}

	/**
	 * This method performs the query on LfDatabaseTraining.employees table.
	 * After query it calls the function displayResult to display the result of
	 * the query.
	 * 
	 * @param id
	 *            {@link Integer} The id of the employee.
	 * @author nimesh
	 */
	private void getFromTableEmployees(int id) {
		LOG.info("Into method getFromTableEmployees.");
		LOG.log(Level.FINE, "The id for query is : " + id);
		try {
			prepared = con
					.prepareStatement("select * from LfDatabaseTraining.employees where id =?");
			prepared.setInt(1, id);
			resultSet = prepared.executeQuery();
			displayResult(resultSet);
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "Exception occurred @ getFromTableEmployees.");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}
	}

	/**
	 * This method performs query on LfDatabaseTraining.salary table. After
	 * query it calls the function displayResult to display the result of the
	 * query.
	 * 
	 * @author nimesh
	 * @param id
	 *            {@link Integer} The id of the employee.
	 */
	private void getFromTableSalary(int id) {
		LOG.info("Into method getFromTableSalary");
		LOG.log(Level.FINE, "The id for query is : " + id);
		try {
			prepared = con
					.prepareStatement("select * from LfDatabaseTraining.salary where id =?");
			prepared.setInt(1, id);
			resultSet = prepared.executeQuery();
			displayResult(resultSet);
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "Exception occurred @ getFromTableSalary");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}
	}

	/**
	 * This method displays the results of the queries performed. The method
	 * first displays the table name and column names Then it displays the rows
	 * of the query.
	 * 
	 * @param result
	 *            {@link ResultSet} The result of the database query.
	 * @author nimesh
	 */
	private void displayResult(ResultSet result) {
		LOG.info("Into method displayResult");
		String tableName;
		if (result != null) {
			try {
				// showing metadata: table name and column names
				tableName = result.getMetaData().getTableName(1);
				LOG.info("Table : " + tableName);
				for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
					LOG.info("Column " + i + " "
							+ result.getMetaData().getColumnName(i));
				}
				// showing query result.
				if (tableName.equals("employees")) {
					LOG.info("Displaying data in table employees");
					while (resultSet.next()) {
						LOG.info("ID : " + result.getInt(1) + "  " + "Name : "
								+ result.getString(2));
					}
				} else if (tableName.equals("salary")) {
					LOG.info("Displaying data in table salary");
					while (result.next()) {
						LOG.info("ID : " + result.getInt(1) + " " + "Salary : "
								+ result.getFloat(2));
					}
				}
			} catch (SQLException e) {
				LOG.log(Level.SEVERE, "Exception occurred @ displayResult.");
				LOG.log(Level.SEVERE, "The message is " + e.getMessage());
			}
		} else {
			LOG.info("Sorry ! The result is null");
		}
	}
	/**
	 * This method gets first name and last name from lfdb database, employees table...
	 * the database used is different from other above methods.
	 * The method uses a sql function to retrive those two values.
	 * @param id {@link Integer} The id of the employee
	 * @return {@link Arrays} {@link String} An array of string containing first and last name.
	 */
	private  String[] getNames(int id){
		String[] names=new String[2];
		LOG.info("Into method getNames");
		LOG.log(Level.FINE, "The id for query is : " + id);
		try {
			CallableStatement call = con.prepareCall("{?=call getEmployees(?)}");
			call.registerOutParameter(1, java.sql.Types.VARCHAR);
			call.setInt(2,id );
			call.execute();
			String firstLastNames=call.getString(1);
			LOG.info("The name is : "+firstLastNames);
			names=firstLastNames.split(",");
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "Exception occurred @ getNames");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}
		return names;
	}

	/**
	 * This is main class
	 * 
	 * @author nimesh
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into main class");
		DatabaseTest dbtest = new DatabaseTest();
		Scanner scan = new Scanner(System.in);
		String choice;
		boolean end = false;
		String []names=dbtest.getNames(3);
		LOG.info("The first name is : "+names[0]+" and the last name is : "+names[1]);
		/*while (!end) {
			LOG.info("Enter e to operate on table employees,s on salary , x to exit");
			choice = scan.next();
			if (choice.equalsIgnoreCase("e")) {
				LOG.info("Enter i to insert and q to query: ");
				choice = scan.next();
				if (choice.equalsIgnoreCase("i")) {
					LOG.info("Enter the name of the employee: ");
					dbtest.insertIntoTableEmployees(scan.next());
				} else if (choice.equalsIgnoreCase("q")) {
					LOG.info("Enter the id of the employee: ");
					dbtest.getFromTableEmployees(scan.nextInt());
				}

			} else if (choice.equalsIgnoreCase("s")) {
				LOG.info("Enter i to insert and q to query: ");
				choice = scan.next();
				if (choice.equalsIgnoreCase("i")) {
					LOG.info("Enter the salary: ");
					dbtest.insertIntoTableSalary(scan.nextInt());
				} else if (choice.equalsIgnoreCase("q")) {
					LOG.info("Enter the id of the employee: ");
					dbtest.getFromTableSalary(scan.nextInt());
				}
			} else if (choice.equalsIgnoreCase("x")) {
				end = true;
			}
		}*/
	}

}
