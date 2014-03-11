package com.lftechnology.employee.controller;

import java.util.List;

import com.lftechnology.employee.Department;
import com.lftechnology.employee.Employee;

/**
 * This interface acts as base for EmployeeControllerImpl
 * @author nimesh
 *
 */
public interface EmployeeController {

	/**
	 * This method is used to get department names.
	 * @return List of objects of {@link Department}
	 * @author nimesh
	 */
	public List<Department> getDepartmentName();
	
	/**
	 * This method is used to get employee details.
	 * @return List of objects of {@link Employee}
	 * @author nimesh
	 */
	public List<Employee> getEmployeeDetail();
}
