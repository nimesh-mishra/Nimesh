
package com.lftechnology.employee.dao;

import java.util.List;

import javax.print.DocFlavor.STRING;

import com.lftechnology.employee.Department;
import com.lftechnology.employee.Employee;

/**
 * This interface is used to build class EmployeeDAOImpl
 * @author nimesh
 *
 */
public interface EmployeeDAO {

	/**
	 * This method returns the list of department names from the database.
	 * @return List of objects of {@link Department}
	 * @author nimesh
	 */
	public List<Department> getDepartmentName();
	
	/**
	 * This method inserts the employee details in the respective tables in the database.
	 * @param employee {@link Employee} The object containing employee details.
	 * @return <code>true</code> if insertion is successful, else <code>false</code>
	 * @author nimesh
	 */
	public boolean insertEmployeeDetails(Employee employee);
	
	/**
	 * This method returns the id of the row in database tabel employee.
	 * 
	 * @param employee
	 *            The {@link Employee}object containing employee details id in database is to be retrieved
	 * @return int The row id
	 * @author nimesh
	 */
	public int getEmployeeId(Employee employee);
	
	/**
	 * This method returns the id of the row in database table "Address"
	 * 
	 * @param empid
	 *            The value of column empId
	 * @return int The row id
	 * @author nimesh
	 */
	public int getAddressId(int empId);
	
	/**
	 * This method returns the id of the row in database table Department.
	 * 
	 * @param bean
	 *            The bean whose properties id in database is to be retrieved
	 * @return int The row id
	 * @author nimesh
	 */
	public int getDepartmentId(Employee employee);
	
	/**
	 * This method is used to get employee details from the database;
	 * @return List of objects of {@link Employee}
	 * @author nimesh
	 */
	public List<Employee> getEmployeeDetail();
	
	/**
	 * This method is used to search employee details based on search keyword.
	 * @param keyword {@link STRING} The keyword on which search is based on.
	 * @return Object List of {@link EmployeeDAOImpl}
	 * @author nimesh
	 */
	public List<Employee> searchEmployeeDetail(String keyword,String filterType);
	
	/**
	 * This method is used to delete employee using his/her id.
	 * @param id {@link Integer} The id of the employee to be deleted.
	 * @author nimesh
	 */
	public void deleteEmployee(int id);
	
	/**
	 * This method retrieves the id of the row in the database table Emp_Address.
	 * @param empId {@link Integer} The employee id used to identify the row to be retrieved.
	 * @return id {@link Integer} The id of the row containing empId.
	 * @author nimesh
	 */
	public int getEmpAddressId(int empId);
	
	/**
	 * This method retrieves the id of the row in the database table Emp_Dept.
	 * @param empId {@link Integer} The employee id used to identify the row to be retrieved.
	 * @return id {@link Integer} The id of the row containing empId.
	 * @author nimesh
	 */
	public int getEmpDeptId(int empId);
	
	/**
	 * This method is used to get employee details corrosponding to the given id.
	 * @param empid {@link Integer} The id of the employee whose details are to be retrieved.
	 * @return employee {@link Employee} The employee object.
	 * @author nimesh
	 */
	public Employee getEmployeeDetail(int empid);
	
	/**
	 * This method is used to update the employee details.
	 * @param employee {@link Employee} The employee object containing the details to be updated to.
	 * @param empid {@link Integer} The id of the employee whose details are to be updated.
	 * @return <code>true</code> if insertion is successful, otherwise <code>false</code>
	 * @author nimesh
	 */
	public boolean updateEmployeeDetail(Employee employee,int empid);
}
