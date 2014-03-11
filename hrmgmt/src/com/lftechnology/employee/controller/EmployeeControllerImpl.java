package com.lftechnology.employee.controller;

import java.util.ArrayList;
import java.util.List;

import com.lftechnology.employee.Department;
import com.lftechnology.employee.Employee;
import com.lftechnology.employee.service.EmployeeServiceImpl;

import java.util.logging.*;
/**
 * This class acts as controller for intermediate requests.
 * This class serves as controller for situation where servlet can't be invoked.
 * Eg. Getting departments name to display in index.jsp.
 * @author nimesh
 *
 */
public class EmployeeControllerImpl implements EmployeeController{

	private static final Logger LOG=Logger.getLogger(EmployeeControllerImpl.class.getName());
	private EmployeeServiceImpl employeeService;
	
	public EmployeeControllerImpl(){
		LOG.info("Into constructor of class EmployeeControllerImpl");
		employeeService=new EmployeeServiceImpl();
	}
	
	public List<Department>getDepartmentName(){
		LOG.info("Into method getDepartmentName");
		List<Department> department=new ArrayList<Department>();
		department=employeeService.getDepartmentName();
		return department;
	}

	public List<Employee> getEmployeeDetail() {
		LOG.info("Into method getEmployeeDetail");
		List<Employee> employee=new ArrayList<Employee>();
		employee=employeeService.getEmployeeDetail();
		return employee;
	}
	
}
