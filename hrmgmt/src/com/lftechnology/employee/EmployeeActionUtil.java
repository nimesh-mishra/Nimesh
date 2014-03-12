package com.lftechnology.employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class creates object of different classes.
 * @author nimesh
 *
 */
public class EmployeeActionUtil {
	
	private static final Logger LOG=Logger.getLogger(EmployeeActionUtil.class.getName());
	/**
	 * This method is used to create object of bean class {@link Department}.
	 * @param deptName {@link String} The name of the department
	 * @return object of  {@link Department} 
	 * @author nimesh
	 */
	public Department getDepartmentObject(String deptName){
		LOG.info("Into method getDepartmentObject");
		Department department = new Department();
		department.setDeptartmentName(deptName);
		return department;
	}
	
	/**
	 * This method is used to create object of class {@link Employee} and set value to its variables
	 * @param request {@link HttpServletRequest}
	 * @param response {@link HttpServletResponse}
	 * @return {@link Employee} The employee object
	 * @author nimesh
	 */
	public Employee getEmployeeObject(HttpServletRequest request, HttpServletResponse response){
		LOG.info("Into method getEmployeeObject");
		Employee employee=new Employee();
		employee.setFirstName(request.getParameter(EmployeeConstants.FIRSTNAME));
		employee.setMiddleName(request.getParameter(EmployeeConstants.MIDDLENAME));
		employee.setLastName(request.getParameter(EmployeeConstants.LASTNAME));
		employee.setGender(request.getParameter(EmployeeConstants.GENDER));
		employee.setAge(Integer.parseInt(request.getParameter(EmployeeConstants.AGE)));
		employee.setCountry(request.getParameter(EmployeeConstants.COUNTRY));
		employee.setZone(request.getParameter(EmployeeConstants.ZONE));
		employee.setDistrict(request.getParameter(EmployeeConstants.DISTRICT));
		employee.setVdcMnc(request.getParameter(EmployeeConstants.VDC_MNC));
		employee.setDepartment(request.getParameter(EmployeeConstants.DEPARTMENT));
		employee.setSubmitButton(request.getParameter(EmployeeConstants.SUBMITBUTTON));
		return employee;
	}
	
	/**
	 * This method is used to set the employee details.
	 * @param resultSet {@link ResultSet}
	 * @return Object List of {@link EmployeeActionUtil}
	 * @author nimesh
	 */
	public List<Employee> getEmployeeDetail(ResultSet resultSet){
		LOG.info("Into method getEmployeeDetail");
		List<Employee> employeeList=new ArrayList<Employee>();
		try {
			if((resultSet!=null)){
				while(resultSet.next()){
					Employee employee=new Employee();
					employee.setId(resultSet.getInt(EmployeeConstants.ID));
					employee.setFirstName(resultSet.getString(EmployeeConstants.FIRSTNAME));
					employee.setMiddleName(resultSet.getString(EmployeeConstants.MIDDLENAME));
					employee.setLastName(resultSet.getString(EmployeeConstants.LASTNAME));
					employee.setCountry(resultSet.getString(EmployeeConstants.COUNTRY));
					employee.setZone(resultSet.getString(EmployeeConstants.ZONE));
					employee.setDistrict(resultSet.getString(EmployeeConstants.DISTRICT));
					employee.setVdcMnc(resultSet.getString(EmployeeConstants.DBVDC));
					employee.setGender(resultSet.getString(EmployeeConstants.GENDER));
					employee.setAge(resultSet.getInt(EmployeeConstants.AGE));
					employee.setDepartment(resultSet.getString(EmployeeConstants.DBDEPT));
					employeeList.add(employee);
				}
			}
			
		} catch (SQLException e) {
			LOG.severe("Exception occurred @getEmployeeDetail");
			LOG.severe("The error message is : "+e.getMessage());
		}
		return employeeList;
	}
	public Employee getSingleEmployeeDetail(ResultSet resultSet){
		Employee employee=new Employee();
		try {
		while(resultSet.next()){
				employee.setId(resultSet.getInt(EmployeeConstants.ID));
				employee.setFirstName(resultSet.getString(EmployeeConstants.FIRSTNAME));
				employee.setMiddleName(resultSet.getString(EmployeeConstants.MIDDLENAME));
				employee.setLastName(resultSet.getString(EmployeeConstants.LASTNAME));
				employee.setCountry(resultSet.getString(EmployeeConstants.COUNTRY));
				employee.setZone(resultSet.getString(EmployeeConstants.ZONE));
				employee.setDistrict(resultSet.getString(EmployeeConstants.DISTRICT));
				employee.setVdcMnc(resultSet.getString(EmployeeConstants.DBVDC));
				employee.setGender(resultSet.getString(EmployeeConstants.GENDER));
				employee.setAge(resultSet.getInt(EmployeeConstants.AGE));
				employee.setDepartment(resultSet.getString(EmployeeConstants.DBDEPT));
			} 
			}catch (SQLException e) {
				LOG.severe("Exception occurred @getSingleEmployeeDetail");
				LOG.severe("The error message is : "+e.getMessage());
		}
		return employee;
	}
}
