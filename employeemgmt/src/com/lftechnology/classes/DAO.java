package com.lftechnology.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.jasper.tagplugins.jstl.core.Param;

/**
 * This class connects to mysql database and performs insertions,queries and
 * delete operations.
 * 
 * @author nimesh
 */
public class DAO extends ConnectionManager {

	private static final Logger LOG = Logger.getLogger(DAO.class.getName());
	private PreparedStatement prepared;
	private ResultSet resultSet;
	private Connection con;

	/**
	 * This is default constructor. This constructor calls the constructor of
	 * class {@link ConnectionManager} which in turn loads the mysql driver for
	 * java. It also initializes {@link Connection} object for this class.
	 * 
	 * @author nimesh
	 */

	public DAO() {
		super();
		LOG.info("Into DAO constructor");
		con = ConnectionManager.getConnection();
	}

	public DeptBean[] getDepartmentName() {
		LOG.info("Into method getDepartmentName()");
		List<DeptBean> dept = new ArrayList<DeptBean>();
		DeptBean[] beanArray = null;
		LOG.info("Into method getDepartmentName");
		try {
			LOG.info("Executing query");
			prepared = con
					.prepareStatement("select COUNT(id) as rowCount from ERP.Department");
			resultSet = prepared.executeQuery();
			LOG.info("Query executed...");

			int rows = 0;
			while (resultSet.next()) {
				rows = Integer.valueOf(resultSet.getInt("rowCount"));
				LOG.info("The row count is : " + rows);
			}
			if (rows > 0) {
				// beanArray = new DeptBean[rows];
				prepared = con
						.prepareStatement("select name from ERP.Department");
				resultSet = prepared.executeQuery();
				while (resultSet.next()) {
					DeptBean bean = new DeptBean();
					String deptName = resultSet.getString("name");
					bean.setDeptName(deptName);
					dept.add(bean);
				}
				beanArray = new DeptBean[dept.size()];
				beanArray = dept.toArray(beanArray);
			} else {
				DeptBean bean = new DeptBean();
				bean.setDeptName("empty");
				beanArray = new DeptBean[1];
				beanArray[0] = bean;
			}
			return beanArray;
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "Exception occurred @ getDepartmentName.");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}
		return beanArray;
	}

	/**
	 * This method inserts employee details in the database.
	 * 
	 * @param bean
	 *            {@link AddEmployeeBean} The bean that contains details to be
	 *            stored
	 * @return <code>true</code> if insertion is successful, otherwise
	 *         <code>false</code>
	 */
	public boolean insertEmployeeDetail(AddEmployeeBean bean) {

		LOG.info("Into method insertEmployeeDetail");
		int empId = 0;
		int empAddressId = 0;
		int deptId = 0;
		// insert into employee
		try {
			prepared = con
					.prepareStatement("insert into ERP.Employee values (default,?,?,?,?,?)");
			prepared.setString(1, bean.getFirstName());
			prepared.setString(2, bean.getMiddleName());
			prepared.setString(3, bean.getLastName());
			prepared.setString(4, bean.getGender());
			prepared.setInt(5, bean.getAge());
			int i = prepared.executeUpdate();
			if (i == 0) {
				LOG.log(Level.SEVERE,
						"Sorry error occurred while inserting data");
				return false;
			} else {
				// insert into address
				LOG.info("Insertion successful at table Employee");
				empId = getEmployeeId(bean);
				prepared = con.prepareStatement("");
				prepared = con
						.prepareStatement("insert into ERP.Address values (default,?,?,?,?,?)");
				prepared.setString(1, bean.getCountry());
				prepared.setString(2, bean.getZone());
				prepared.setString(3, bean.getDistrict());
				prepared.setString(4, bean.getVdcMnc());
				prepared.setInt(5, empId);
				i = prepared.executeUpdate();
				if (i == 0) {
					int rowId = getEmployeeId(bean);
					boolean success = deleteRow(rowId, "Employee");
					if (success) {
						LOG.info("Inserted Row deleted successfully..");
						return false;
					} else {
						LOG.info("Inserted Row deletion unsuccessful");
						return false;
					}
				} else {
					// insert into Emp_Address
					LOG.info("Insertion successful into table Address");
					empAddressId = getAddressId(empId);
					prepared = con
							.prepareStatement("insert into ERP.Emp_Address values(default,?,?)");
					prepared.setInt(1, empId);
					prepared.setInt(2, empAddressId);
					i = prepared.executeUpdate();
					if (i == 0) {
						boolean success = deleteRow(empId, "Employee");
						if (success) {
							LOG.info("Inserted Row deleted successfully from Employee table..");
							boolean successTwo = deleteRow(empAddressId,
									"Address");
							if (successTwo) {
								LOG.info("Inserted Row deleted successfully from address table..");
							}
							return false;
						} else {
							LOG.info("Inserted Row deletion unsuccessful");
							return false;
						}
					} else {
						// insert into emp_dept
						deptId = getDepartmentId(bean);
						prepared = con
								.prepareStatement("insert into ERP.Emp_Dept values(default,?,?)");
						prepared.setInt(1, empId);
						prepared.setInt(2, deptId);
						i = prepared.executeUpdate();
						if (i == 0) {
							boolean success = deleteRow(empId, "Employee");
							if (success) {
								LOG.info("Inserted Row deleted successfully from Employee table..");
								boolean successTwo = deleteRow(empAddressId,
										"Address");
								if (successTwo) {
									LOG.info("Inserted Row deleted successfully from address table..");
									int empAddressTableId = getEmpAddressId(
											empId, empAddressId);
									boolean successThree = deleteRow(
											empAddressTableId, "Emp_Address");
									if (successThree) {
										LOG.info("inserted Row deleted Successfully from Emp_Address table...");
									} else {
										LOG.info("insreted row deletion unsuccessful from Emp_Address table");
									}
								} else {
									LOG.info("Inserted row deletion unsuccessful from Address table");
								}
								return false;
							} else {
								LOG.info("Inserted row deletion unsuccessful from Employee table");
								return false;
							}
						} else {
							LOG.info("Row insertion successful in all tables");
							return true;
						}
					}
				}
			}

		} catch (SQLException e) {
			LOG.log(Level.SEVERE,
					"Exception occurred at insertEmployeeDetail. ");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}
		return false;
	}

	/**
	 * This method is used to delete a row of database
	 * 
	 * @param id
	 *            The id of the row to be deleted
	 * @param tableName
	 *            The table whose row is to be deleted.
	 * @return <code>true</code> if deletion is successful, else
	 *         <code>false</code>
	 */
	public boolean deleteRow(int id, String tableName) {
		LOG.info("into method deleteRow");
		try {
			prepared = con.prepareStatement("delete from ERP." + tableName
					+ "where id=?");
			prepared.setInt(1, id);
			int i = prepared.executeUpdate();
			if (i == 0) {
				LOG.severe("row deletion of table: " + tableName + " id: " + id
						+ " failed..");
				return false;
			} else {
				LOG.info("Row of table :" + tableName + "id : " + id
						+ "deleted successfully..");
			}
		} catch (SQLException e) {
			LOG.severe("Exception occurred");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}
		;
		return false;
	}

	/**
	 * This method returns the id of the row in database tabel employee.
	 * 
	 * @param bean
	 *            The bean whose properties id in database is to be retrieved
	 * @return int The row id
	 * @author nimesh
	 */
	public int getEmployeeId(AddEmployeeBean bean) {
		LOG.info("Into method getEmployeeId");
		int rowId = 0;

		try {
			prepared = con
					.prepareStatement("select id from ERP.Employee where firstName=? and middleName=? and lastName=? and  gender=? and age=?");
			prepared.setString(1, bean.getFirstName());
			prepared.setString(2, bean.getMiddleName());
			prepared.setString(3, bean.getLastName());
			prepared.setString(4, bean.getGender());
			prepared.setInt(5, bean.getAge());
			resultSet = prepared.executeQuery();
			while (resultSet.next()) {
				rowId = resultSet.getInt("id");
			}
		} catch (SQLException e) {
			LOG.severe("Exception occurred @getEmployeeId");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}

		return rowId;
	}

	/**
	 * This method returns the id of the row in database table "Address"
	 * 
	 * @param empid
	 *            The value of column empId
	 * @return int The row id
	 * @author nimesh
	 */
	public int getAddressId(int empId) {
		LOG.info("Into method getAddressId");
		int rowId = 0;

		try {
			prepared = con
					.prepareStatement("select id from ERP.Address where empId=?");
			prepared.setInt(1, empId);
			resultSet = prepared.executeQuery();
			while (resultSet.next()) {
				rowId = resultSet.getInt("id");
			}
		} catch (SQLException e) {
			LOG.severe("Exception occurred @getEmployeeId");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}

		return rowId;
	}

	/**
	 * This method returns the id of the row in database table Department.
	 * 
	 * @param bean
	 *            The bean whose properties id in database is to be retrieved
	 * @return int The row id
	 * @author nimesh
	 */
	public int getDepartmentId(AddEmployeeBean bean) {
		LOG.info("Into method getDepartmentId");
		int rowId = 0;

		try {
			prepared = con
					.prepareStatement("select id from ERP.Department where name=?");
			prepared.setString(1, bean.getDept());
			resultSet = prepared.executeQuery();
			while (resultSet.next()) {
				rowId = resultSet.getInt("id");
			}
		} catch (SQLException e) {
			LOG.severe("Exception occurred @getEmployeeId");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}

		return rowId;
	}

	/**
	 * This method returns the id of the row in database table Emp_Address.
	 * 
	 * @param empId
	 *            The id of the employee {@link Param} The id of the Address
	 * @return int The row id
	 * @author nimesh
	 */
	public int getEmpAddressId(int empId, int empAddressId) {
		LOG.info("Into method getEmpAddressId");
		int rowId = 0;

		try {
			prepared = con
					.prepareStatement("select id from ERP.Emp_Address where empId=? and empAddressId=?");
			prepared.setInt(1, empId);
			prepared.setInt(2, empAddressId);
			resultSet = prepared.executeQuery();
			while (resultSet.next()) {
				rowId = resultSet.getInt("id");
			}
		} catch (SQLException e) {
			LOG.severe("Exception occurred @getEmpAddressId");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}

		return rowId;
	}

	/**
	 * This method returns all employee details To do this, this method performs
	 * muliple join operations.
	 * 
	 * @return ObjectArray of {@link AddEmployeeBean}
	 * @author nimesh
	 */
	public AddEmployeeBean[] getEmployeeDetails() {
		LOG.info("Into method getEmployeeDetails");
		EmployeeActionUtil action = new EmployeeActionUtil();
		try {
			prepared = con
					.prepareStatement("select firstName,middleName,lastName,gender,age,country,zone,district,name,vdc_mnc from ERP.Employee inner join (ERP.Address inner join (ERP.Emp_Dept inner join ERP.Department)) on Employee.id=Address.empId and Address.empId=Emp_Dept.empId and Emp_Dept.deptId=Department.id;");
			resultSet = prepared.executeQuery();

		} catch (SQLException e) {
			LOG.severe("Exception occurred @getEmployeeDetails");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}
		return action.setEmployeeBean(resultSet);
	}
}
