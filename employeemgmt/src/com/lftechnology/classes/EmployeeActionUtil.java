package com.lftechnology.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lftechnology.servlet.EmployeeAddServlet;
import java.util.logging.*;

/**
 * This class is used to construct bean class objects and send it to respective
 * caller. This class methods receive request {@link HttpServletRequest} and
 * response {@link HttpServletResponse} objects and uses their parameter to set
 * the properties of bean class.
 * 
 * @author nimesh
 * 
 */
public class EmployeeActionUtil {
	private static final Logger LOG = Logger.getLogger(EmployeeActionUtil.class
			.getName());

	/**
	 * This method sets the bean for {@link EmployeeAddServlet}
	 * 
	 * @param request
	 *            {@link HttpServletRequest}
	 * @param response
	 *            {@link HttpServletResponse}
	 * @return {@link AddEmployeeBean}
	 */
	public AddEmployeeBean getAddEmployeeBean(HttpServletRequest request,
			HttpServletResponse response) {
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		int age = Integer.valueOf(request.getParameter("age"));
		String country = request.getParameter("country");
		String zone = request.getParameter("zone");
		String district = request.getParameter("district");
		String vdcMnc = request.getParameter("vdcMnc");
		String dept = request.getParameter("dept");

		AddEmployeeBean bean = new AddEmployeeBean();
		bean.setFirstName(firstName);
		bean.setMiddleName(middleName);
		bean.setLastName(lastName);
		bean.setGender(gender);
		bean.setAge(age);
		bean.setCountry(country);
		bean.setZone(zone);
		bean.setDistrict(district);
		bean.setVdcMnc(vdcMnc);
		bean.setDept(dept);
		return bean;
	}

	/**
	 * This method sets the details of employees in {@link AddEmployeeBean}
	 * class. The object array of class {@link AddEmployeeBean} is then used to
	 * display the details.
	 * 
	 * @param result
	 *            {@link ResultSet} The ResultSet object that contains query
	 *            result, i.e the employees details.
	 * @return object array of class {@link AddEmployeeBean}
	 * @author nimesh
	 */
	public AddEmployeeBean[] setEmployeeBean(ResultSet result) {
		LOG.info("Into method setEmployeeBean");
		List<AddEmployeeBean> employeeList = new ArrayList<AddEmployeeBean>();
		try {
			while (result.next()) {
				AddEmployeeBean employee = new AddEmployeeBean();
				employee.setFirstName(result.getString("firstName"));
				employee.setMiddleName(result.getString("middleName"));
				employee.setLastName(result.getString("lastName"));
				employee.setZone(result.getString("zone"));
				employee.setDistrict(result.getString("district"));
				employee.setVdcMnc(result.getString("vdc_mnc"));
				employee.setGender(result.getString("gender"));
				employee.setAge(result.getInt("age"));
				employee.setDept(result.getString("name"));
				employeeList.add(employee);
			}
			AddEmployeeBean[] employeeArray = new AddEmployeeBean[employeeList
			                                                      .size()];
			return employeeList.toArray(employeeArray);
		} catch (SQLException e) {
			LOG.info("Error occurred @ AddEmployeeBean() in class EmployeeActionUtil");
			LOG.info("The error message is : " + e.getMessage());
		}
		return null;
	}
}
