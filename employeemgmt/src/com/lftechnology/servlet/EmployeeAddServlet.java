package com.lftechnology.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lftechnology.classes.AddEmployeeBean;
import com.lftechnology.classes.DAO;
import com.lftechnology.classes.EmployeeActionUtil;
import java.util.logging.*;

/**
 * This servlet class takes parameters from servlet class
 * {@link EmployeeAddForm} and inserts them into the database.
 * 
 * @author nimesh
 */
@WebServlet("/EmployeeAddServlet")
public class EmployeeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(
			EmployeeAddServlet.class.getName(), null);
	private DAO db;

	/**
	 * Default constructor Used to initialize class {@link DAO}
	 * 
	 * @author nimesh
	 */
	public EmployeeAddServlet() {
		db = new DAO();
	}

	/**
	 * This method receives the values of form parameters from
	 * {@link EmployeeAddForm} and inserts them into database.
	 * 
	 * @param request
	 *            {@link HttpServletRequest} The request object
	 * @param response
	 *            {@link HttpServletResponse} The response object
	 * @author nimesh
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// LOG.info("Into method doPost of class EmployeeAddServlet...");
		EmployeeActionUtil action = new EmployeeActionUtil();
		AddEmployeeBean bean = new AddEmployeeBean();
		bean = action.getAddEmployeeBean(request, response);
		boolean success = db.insertEmployeeDetail(bean);
		if (success) {
			LOG.info("Data inserted Successfully ");
			RequestDispatcher dispatch = request
					.getRequestDispatcher("/ViewEmployeeServlet");
			dispatch.forward(request, response);

		} else {
			LOG.severe("Sorry!! Error occurred while inserting data...");
		}

	}

}
