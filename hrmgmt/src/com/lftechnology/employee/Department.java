package com.lftechnology.employee;

/**
 * This class is used to store and communicate department names.
 * This class is called by class EmployeeActionUtil to set and get the department names 
 * @author nimesh
 *
 */
public class Department {
	private String deptartmentName;

	public String getDeptartmentName() {
		return deptartmentName;
	}

	public void setDeptartmentName(String deptartmentName) {
		this.deptartmentName = deptartmentName;
	}
}
