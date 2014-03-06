package com.lftechnology.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lftechnology.classes.AddEmployeeBean;
import com.lftechnology.classes.DAO;
import com.lftechnology.classes.EmployeeActionUtil;

/**
 * This servlet class is used to show the employee details. Thus this class acts
 * as a view class.
 * 
 * @author nimesh
 */
@WebServlet("/ViewEmployeeServlet")
public class ViewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO db;
	private EmployeeActionUtil action;

	/**
	 * Default constructor
	 * 
	 * @author nimesh
	 */
	public ViewEmployeeServlet() {
		db = new DAO();
		action = new EmployeeActionUtil();
	}

	/**
	 * This method is called by servlet class {@link EmployeeAddServlet} to show
	 * the employee data. This method is called by default by
	 * {@link RequestDispatcher}.
	 * 
	 * @param request
	 *            {@link HttpServletRequest} The request object
	 * @param response
	 *            {@link HttpServletResponse} The response object.
	 * @author nimesh
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AddEmployeeBean[] employeeBean = db.getEmployeeDetails();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Employee Details</title>");
		out.println("<script src='scripts.js'></script>");
		out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>View Employee here</h1>");
		out.println("<div id='view-table'>");
		out.println("<table cellpadding='5'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>FirstName</th>");
		out.println("<th>MiddleName</th>");
		out.println("<th>LastName</th>");
		out.println("<th>Gender</th>");
		out.println("<th>Age</th>");
		out.println("<th>Country</th>");
		out.println("<th>Zone</th>");
		out.println("<th>District</th>");
		out.println("<th>VDC?MNC</th>");
		out.println("<th>Department</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for (int i = 0; i < employeeBean.length; i++) {
			out.println("<tr>");
			out.println("<td>" + employeeBean[i].getFirstName() + "</td>");
			out.println("<td>" + employeeBean[i].getMiddleName() + "</td>");
			out.println("<td>" + employeeBean[i].getLastName() + "</td>");
			out.println("<td>" + employeeBean[i].getGender() + "</td>");
			out.println("<td>" + employeeBean[i].getAge());
			out.println("<td>Nepal</td>");
			out.println("<td>" + employeeBean[i].getZone() + "</td>");
			out.println("<td>" + employeeBean[i].getDistrict() + "</td>");
			out.println("<td>" + employeeBean[i].getVdcMnc() + "</td>");
			out.println("<td>" + employeeBean[i].getDept() + "</td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

}
