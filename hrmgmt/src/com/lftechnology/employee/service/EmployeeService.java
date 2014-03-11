package com.lftechnology.employee.service;

import java.util.List;

import javax.print.DocFlavor.STRING;

import com.lftechnology.employee.Department;
import com.lftechnology.employee.Employee;
import com.lftechnology.employee.dao.EmployeeDAOImpl;

/**
 * This interface will act as base for class {@link EmployeeServiceImpl}
 * @author nimesh
 *
 */
public interface EmployeeService {

	/**
	 * This method is used to get department names from database access object class.
	 * @return object list of {@link Department}
	 * @author nimesh
	 */
	public List<Department> getDepartmentName();
	
	/**
	 * This method is used to insert employee details in the database.
	 * This method calls method insertEmployeeDetail of class {@link EmployeeDAOImpl} to do so.
	 * @param employee {@link Employee} The object of class {@link Employee}
	 * @return <code>true</code> if insertion is successful, else <code>false</code>
	 */
	public boolean insertEmployeeDetails(Employee employee);
	
	/**
	 * This method is used to get employee details.
	 * @return List of objects of {@link Employee}
	 * @author nimesh
	 */
	public List<Employee> getEmployeeDetail();
	
	/**
	 * This method is used to search employeeDetails based on search keyword.
	 * @param keyword {@link STRING} The keyword on which search is based on.
	 * @return Object List of {@link EmployeeDAOImpl}
	 * @author nimesh
	 */
	public List<Employee>searchEmployeeDetail(String keyword,String filterType);
	
	/**
	 * This method is used to delete employee using his/her id.
	 * @param id {@link Integer} The id of the employee to be deleted.
	 * @author nimesh
	 */
	public void deleteEmployee(int id);
	
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
