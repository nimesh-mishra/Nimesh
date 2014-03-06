package com.lftechnology.classes;

import com.lftechnology.servlet.EmployeeAddServlet;

/**
 * This class is used to store parameters that class {@link EmployeeAddServlet} received and needs to pass to 
 * class {@link DAO} in order to insert that into database.
 * @author nimesh
 *
 */
public class AddEmployeeBean {
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private int age;
	private String country;
	private String zone;
	private String district;
	private String vdcMnc;
	private String dept;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getVdcMnc() {
		return vdcMnc;
	}
	public void setVdcMnc(String vdcMnc) {
		this.vdcMnc = vdcMnc;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

}
