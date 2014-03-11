package com.lftechnology.employee.service;

import java.util.ArrayList;
import java.util.List;

import com.lftechnology.employee.Department;
import com.lftechnology.employee.Employee;
import com.lftechnology.employee.dao.EmployeeDAOImpl;

import java.util.logging.*;
/**
 * This class is the implementation class of interface {@link EmployeeService}
 * This class acts as service class i.e mediator between controller classes {@link And} {@link EmployeeDAOImpl}
 * @author nimesh
 *
 */
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger LOG=Logger.getLogger(EmployeeServiceImpl.class.getName());
	private EmployeeDAOImpl daoImpl;
	
	/**
	 * Into the constructor of class {@link EmployeeServiceImpl}
	 * @author nimesh
	 */
	public EmployeeServiceImpl(){
		daoImpl=new EmployeeDAOImpl();
	}

	public List<Department> getDepartmentName() {
		LOG.info("Into method getDepartmentName");
		List<Department>department=new ArrayList<Department>();
		department=daoImpl.getDepartmentName();
		return department;
	}
	
	public boolean insertEmployeeDetails(Employee employee){
		LOG.info("Into method insertEmployeeDetails");
		return(daoImpl.insertEmployeeDetails(employee));
	}
	
	public List<Employee> getEmployeeDetail() {
		LOG.info("Into method getEmployeeDetail");
//		List<Employee> employee=new ArrayList<Employee>();
//		employee=daoImpl.getEmployeeDetail();
		return daoImpl.getEmployeeDetail();
	}

	public List<Employee> searchEmployeeDetail(String keyword, String filterType) {
		LOG.info("Into method searchEmployeeDetail");
//		List<Employee> employee=new ArrayList<Employee>();
//		employee=daoImpl.searchEmployeeDetail(keyword,filterType);
		return daoImpl.searchEmployeeDetail(keyword,filterType);
	}

	@Override
	public void deleteEmployee(int id) {
		daoImpl.deleteEmployee(id);
	}

	@Override
	public Employee getEmployeeDetail(int empid) {
		return daoImpl.getEmployeeDetail(empid);
	}

	@Override
	public boolean updateEmployeeDetail(Employee employee,int empId) {
		return daoImpl.updateEmployeeDetail(employee,empId);
	}
}
