package com.lftechnology.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lftechnology.classes.DAO;
import com.lftechnology.classes.DeptBean;

/**
 * This servlet class adds the employee information into the database.
 * This servlet takes the user data through a form and inserts it into the database.
 * @author nimesh
 */
@WebServlet("/EmployeeAddForm")
public class EmployeeAddForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DAO db;  
    /**
     * Default constructor for servlet class EmployeeAddForm
     * @author nimesh
     */
    public EmployeeAddForm() {
        db=new DAO();
    }
	/**
	 * The doGet method
	 * @param request {@link HttpServletRequest} The request object
	 * @param response {@link HttpServletResponse} The response object
	 * @author nimesh
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method
	 * @param request {@link HttpServletRequest} The request object
	 * @param response {@link HttpServletResponse} The response object
	 * @author nimesh
	 */
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Employee</title>");
		out.println("<script src='scripts.js'></script>");
		out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Add Employee here</h1>");
		out.println("<form action='/EmployeeAddServlet' name='addEmployee' method='post' onsubmit='return validateForm()'>");
		out.println("<fieldset><legend>Enter personal details here.</legend>");
		out.println("<label>Enter The First Name</label>");
		out.println("<input name='firstName' type='text'value='Enter First Name here' autofocus='autofocus' onclick='clearThis(this)'><br>");
		
		out.println("<label>Enter The Middle Name</label>");
		out.println("<input name='middleName' type='text' value='Enter Middle Name here' onclick='clearThis(this)''><br>");
		
		out.println("<label>Enter The Last Name</label>");
		out.println("<input name='lastName' type='text' value='Enter Last Name here' onclick='clearThis(this)''><br>");
		
		out.println("<label>Choose Gender</label>");
		out.println("<br><input id='typeradio' type='radio' name='gender' value='male' checked >Male</input>");
		out.println("<br><input id='typeradio' type='radio' name='gender' value='female' >Female</input>");

		out.println("<label>Enter your Age:</label>");
		out.println("<input name='age' type='text' value='Enter Age here' onclick='clearThis(this)''><br>");
		
		out.println("<label>Enter your Age:</label>");
		out.println("<input name='age' type='text' value='Enter Age here' onclick='clearThis(this)''><br>");
		out.println("</fieldset>");
		
		
		out.println("<fieldset><legend>Enter your location information</legend>");
		
		out.println("<label>Enter your country:</label>");
		out.println("<input name='country' type='text' value='Nepal''><br>");
		
		out.println("<label>Enter your Zone:</label>");
		out.println("<input name='zone' type='text' value='Enter Zone here' onclick='clearThis(this)''><br>");
		
		out.println("<label>Enter your District:</label>");
		out.println("<input name='district' type='text' value='Enter District here' onclick='clearThis(this)''><br>");
		
		out.println("<label>Enter your VDC/MNC:</label>");
		out.println("<input name='vdcMnc' type='text' value='Enter VDC/MNC here' onclick='clearThis(this)''><br>");
		
		out.println("<label>Select your Department:</label>");
		out.println("<select>");
		out.println("</select>");
		out.println("</fieldset>");
		
		
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
