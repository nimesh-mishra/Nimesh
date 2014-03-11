package com.lftechnology.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.employee.Department;
import com.lftechnology.employee.Employee;
import com.lftechnology.employee.EmployeeActionUtil;
import com.lftechnology.employee.db.DbUtils;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger LOG = Logger.getLogger(EmployeeDAOImpl.class
			.getName());
	private PreparedStatement prepared;
	private PreparedStatement preparedTwo;
	private PreparedStatement preparedThree;
	private PreparedStatement preparedFour;

	private ResultSet resultSet;
	private Connection con;
	private EmployeeActionUtil employeeAction;

	public EmployeeDAOImpl() {
		LOG.info("Into constructor of EmployeeDAOImpl");
		LOG.info("Getting Connection Object");
		con = DbUtils.getConnection();
		employeeAction = new EmployeeActionUtil();
	}

	@Override
	public List<Department> getDepartmentName() {
		LOG.info("Into method getDepartmentName()");
		List<Department> departmentArray = new ArrayList<Department>();
		try {
			LOG.info("Executing query");
			prepared = con.prepareStatement("select name from ERP.Department");
			resultSet = prepared.executeQuery();
			LOG.info("Query executed...");
			while (resultSet.next()) {
				String deptName = resultSet.getString("name");
				departmentArray.add(employeeAction
						.getDepartmentObject(deptName));
			}
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "Exception occurred @ getDepartmentName.");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}
		return departmentArray;
	}

	public boolean insertEmployeeDetails(Employee employee) {

		LOG.info("Into method insertEmployeeDetails");
		int empId = 0;
		int empAddressId = 0;
		int deptId = 0;
		// insert into employee
		try {
			prepared = con
					.prepareStatement("insert into ERP.Employee values (default,?,?,?,?,?)");
			prepared.setString(1, employee.getFirstName());
			prepared.setString(2, employee.getMiddleName());
			prepared.setString(3, employee.getLastName());
			prepared.setString(4, employee.getGender());
			prepared.setInt(5, employee.getAge());
			prepared.executeUpdate();
			// insert into address
			LOG.info("Insertion successful at table Employee");
			empId = getEmployeeId(employee);
			preparedTwo = con
					.prepareStatement("insert into ERP.Address values (default,?,?,?,?,?)");
			preparedTwo.setString(1, employee.getCountry());
			preparedTwo.setString(2, employee.getZone());
			preparedTwo.setString(3, employee.getDistrict());
			preparedTwo.setString(4, employee.getVdcMnc());
			preparedTwo.setInt(5, empId);
			preparedTwo.executeUpdate();
			// insert into Emp_Address
			LOG.info("Insertion successful into table Address");
			empAddressId = getAddressId(empId);
			preparedThree = con
					.prepareStatement("insert into ERP.Emp_Address values(default,?,?)");
			preparedThree.setInt(1, empId);
			preparedThree.setInt(2, empAddressId);
			preparedThree.executeUpdate();

			// insert into emp_dept
			deptId = getDepartmentId(employee);
			preparedFour = con
					.prepareStatement("insert into ERP.Emp_Dept values(default,?,?)");
			preparedFour.setInt(1, empId);
			preparedFour.setInt(2, deptId);
			preparedFour.executeUpdate();

			con.commit();
			return true;
		} catch (SQLException e) {
			LOG.log(Level.SEVERE,
					"Exception occurred at insertEmployeeDetail. Committing Rollback ");
			try {
				con.rollback();
			} catch (SQLException e1) {
				LOG.log(Level.SEVERE, "Exception occurred while rolling back.");
				LOG.log(Level.SEVERE, "The message is " + e1.getMessage());
			}
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
			return false;
		}
	}

	public int getEmployeeId(Employee employee) {
		LOG.info("Into method getEmployeeId");
		int rowId = 0;

		try {
			prepared = con
					.prepareStatement("select id from ERP.Employee where firstName=? and middleName=? and lastName=? and  gender=? and age=?");
			prepared.setString(1, employee.getFirstName());
			prepared.setString(2, employee.getMiddleName());
			prepared.setString(3, employee.getLastName());
			prepared.setString(4, employee.getGender());
			prepared.setInt(5, employee.getAge());
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

	public int getDepartmentId(Employee employee) {
		LOG.info("Into method getDepartmentId");
		int rowId = 0;

		try {
			prepared = con
					.prepareStatement("select id from ERP.Department where name=?");
			prepared.setString(1, employee.getDepartment());
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

	public List<Employee> getEmployeeDetail() {
		LOG.info("Into method getEmployeeDetail");
		try {
			prepared = con
					.prepareStatement("select Employee.id,firstName,middleName,lastName,gender,age,country,zone,district,name,vdc_mnc from ERP.Employee inner join (ERP.Address inner join (ERP.Emp_Dept inner join ERP.Department)) on Employee.id=Address.empId and Address.empId=Emp_Dept.empId and Emp_Dept.deptId=Department.id;");
			resultSet = prepared.executeQuery();

		} catch (SQLException e) {
			LOG.severe("Exception occurred @getEmployeeDetails");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}
		return employeeAction.getEmployeeDetail(resultSet);
	}

	public List<Employee> searchEmployeeDetail(String keyword, String filterType) {
		LOG.info("Into method getSearchEmployeeDetail");

		// for empty search and empty filter
		if ((keyword == null || keyword.equals("") || keyword.contains("Enter"))
				&& (filterType.equals("") || filterType == null)) {
			return (getEmployeeDetail());
		}
		// for empty search and non-empty filter
		else if ((keyword == null || keyword.equals("")||keyword.contains("Enter"))
				&& !(filterType == null || filterType.equals(""))) {
			try {
				prepared = con
						.prepareStatement("select Employee.id,firstName,middleName,lastName,gender,age,country,zone,district,name,vdc_mnc from ERP.Employee inner join (ERP.Address inner join (ERP.Emp_Dept inner join ERP.Department)) on Employee.id=Address.empId and Address.empId=Emp_Dept.empId and Emp_Dept.deptId=Department.id where Department.name REGEXP ?");
				prepared.setString(1,filterType);
				resultSet = prepared.executeQuery();

			} catch (SQLException e) {
				LOG.severe("Exception occurred @getEmployeeDetails");
				LOG.log(Level.SEVERE, "The message is " + e.getMessage());
			}
			return employeeAction.getEmployeeDetail(resultSet);
		} else if (!(keyword == null || keyword.equals(""))
				&& !(filterType == null || filterType.equals(""))) {
			try {
				prepared = con
						.prepareStatement("select Employee.id,firstName,middleName,lastName,gender,age,country,zone,district,name,vdc_mnc from ERP.Employee inner join (ERP.Address inner join (ERP.Emp_Dept inner join ERP.Department)) on Employee.id=Address.empId and Address.empId=Emp_Dept.empId and Emp_Dept.deptId=Department.id where Employee.firstName REGEXP ? or Employee.middleName REGEXP ? or Employee.lastName REGEXP ? and Department.name REGEXP ?");
				prepared.setString(1,keyword );
				prepared.setString(2,keyword );
				prepared.setString(3, keyword );
				prepared.setString(4, filterType);
				resultSet = prepared.executeQuery();

			} catch (SQLException e) {
				LOG.severe("Exception occurred @getEmployeeDetails");
				LOG.log(Level.SEVERE, "The message is " + e.getMessage());
			}
			return employeeAction.getEmployeeDetail(resultSet);
		}

		else {
			try {
				prepared = con
						.prepareStatement("select Employee.id,firstName,middleName,lastName,gender,age,country,zone,district,name,vdc_mnc from ERP.Employee inner join (ERP.Address inner join (ERP.Emp_Dept inner join ERP.Department)) on Employee.id=Address.empId and Address.empId=Emp_Dept.empId and Emp_Dept.deptId=Department.id where Employee.firstName REGEXP ? or Employee.middleName REGEXP ? or Employee.lastName REGEXP ?");
				prepared.setString(1,keyword );
				prepared.setString(2,keyword );
				prepared.setString(3, keyword );
				resultSet = prepared.executeQuery();

			} catch (SQLException e) {
				LOG.severe("Exception occurred @getEmployeeDetails");
				LOG.log(Level.SEVERE, "The message is " + e.getMessage());
			}
			return employeeAction.getEmployeeDetail(resultSet);
		}
	}

	@Override
	public void deleteEmployee(int id) {
		int addressId = 0;
		int deptId = 0;
		try {
			prepared = con
					.prepareStatement("Delete from ERP.Employee where id=?");
			prepared.setInt(1,id );			
			prepared.executeUpdate();
			addressId = getAddressId(id);
			preparedTwo=con.prepareStatement("Delete from ERP.Employee where id=? ");
			preparedTwo.setInt(1, addressId);
			preparedTwo.executeUpdate();
			int empAddressId=getEmpAddressId(id);
			preparedThree=con.prepareStatement("Delete from ERP.Emp_Address where id=?");
			preparedThree.setInt(1, empAddressId);
			preparedThree.executeUpdate();
			deptId=getEmpDeptId(id);
			preparedFour=con.prepareStatement("Delete from ERP.Emp_Dept where id =?");
			preparedFour.setInt(1, deptId);
			preparedFour.executeQuery();
			con.commit();
			

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				LOG.severe("Exception occurred while performing rollback..");
				LOG.severe("The error message is "+e.getMessage());
			}
			LOG.severe("Exception occurred @getEmployeeDetails");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}
		
	}

	@Override
	public int getEmpAddressId(int empId) {
		LOG.info("Into method getEmpAddressId");
		int rowId = 0;

		try {
			prepared = con
					.prepareStatement("select id from ERP.Emp_Address where empId=?");
			prepared.setInt(1, empId);
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

	@Override
	public int getEmpDeptId(int empId) {
		LOG.info("Into method getEmpDeptId");
		int rowId = 0;

		try {
			prepared = con
					.prepareStatement("select id from ERP.Emp_Dept where empId=?");
			prepared.setInt(1, empId);
			resultSet = prepared.executeQuery();
			while (resultSet.next()) {
				rowId = resultSet.getInt("id");
			}
		} catch (SQLException e) {
			LOG.severe("Exception occurred @getEmpDeptId");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}

		return rowId;
	}

	@Override
	public Employee getEmployeeDetail(int empid) {
		LOG.info("Into method getEmployeeDetail");
		try {
			prepared = con
					.prepareStatement("select Employee.id,firstName,middleName,lastName,gender,age,country,zone,district,name,vdc_mnc from ERP.Employee inner join (ERP.Address inner join (ERP.Emp_Dept inner join ERP.Department)) on Employee.id=Address.empId and Address.empId=Emp_Dept.empId and Emp_Dept.deptId=Department.id and Employee.id=?;");
			prepared.setInt(1, empid);
			resultSet = prepared.executeQuery();

		} catch (SQLException e) {
			LOG.severe("Exception occurred @getEmployeeDetails");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}
		return employeeAction.getSingleEmployeeDetail(resultSet);
	}

	@Override
	public boolean updateEmployeeDetail(Employee employee,int empId) {
		try {
			prepared = con
					.prepareStatement("update Employee set firstName=?,middleName=?,lastName=?,gender=?,age=? where id=?");
			prepared.setString(1, employee.getFirstName());
			prepared.setString(2, employee.getMiddleName());
			prepared.setString(3, employee.getLastName());
			prepared.setString(4, employee.getGender());
			prepared.setInt(5, employee.getAge());
			prepared.setInt(6, empId);
			prepared.executeUpdate();
			
			preparedTwo=con.prepareStatement("update Address set country=?,zone=?,district=?,vdc_mnc=? where empId=?");
			preparedTwo.setString(1, employee.getCountry());
			preparedTwo.setString(2, employee.getZone());
			preparedTwo.setString(3, employee.getDistrict());
			preparedTwo.setString(4, employee.getVdcMnc());
			preparedTwo.setInt(5, empId);
			preparedTwo.executeUpdate();
			
			preparedThree=con.prepareStatement("update Emp_Dept set deptId=? where empId=?");
			preparedThree.setInt(1, getDepartmentId(employee));
			preparedThree.setInt(2, empId);
			preparedThree.executeQuery();
			con.commit();

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			LOG.severe("Exception occurred @getEmployeeDetails");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
			return false;
		}
		return true;
	}

}
