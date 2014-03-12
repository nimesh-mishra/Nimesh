package com.lftechnology.employee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lftechnology.employee.Employee;
import com.lftechnology.employee.EmployeeActionUtil;
import com.lftechnology.employee.service.EmployeeServiceImpl;

/**
 * This servlet class acts as controller for the application.
 * 
 * @author nimesh
 */
@WebServlet("/EmployeeControllerServlet")
public class EmployeeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger LOG = Logger
			.getLogger(EmployeeControllerServlet.class.getName());
	private static final String ADDEMPLOYEE = "addEmployee.jsp";
	private static final String VIEWEMPLOYEE = "viewEmployee.jsp";
	private static final String SEARCHEMPLOYEE = "searchEmployee.jsp";
	public static final String SEARCHKEYWORD = "searchKeyword";
	public static final String FILTERTYPE = "filterType";
	public static final String PAGETYPE = "pageType";
	private static final String SEARCH = "search";
	private static final String VIEW = "view";
	private static final String ADD = "add";
	private static final String SUBMIT = "submit";
	private static final String SUBMITANDADD = "submitAndAdd";
	public static final String UPDATE="update";
	private EmployeeActionUtil employeeAction;
	private Employee employee;
	private EmployeeServiceImpl employeeServiceImpl;
	private List<Employee> employeeList;

	/**
	 * Default Constructor of {@link EmployeeControllerServlet}
	 * 
	 * @author nimesh
	 */
	public EmployeeControllerServlet() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * This post method gets the url from the request object. It then maps the
	 * url to the specific method which in turn handles the request.
	 * 
	 * @author nimesh
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		employeeAction = new EmployeeActionUtil();
		employee = new Employee();
		employeeServiceImpl = new EmployeeServiceImpl();
		String pageType = (String) request.getAttribute(PAGETYPE);
		String update=(String) request.getParameter(UPDATE);
		String requestUrl = request.getHeader("Referer");
		LOG.info("the page type is " + pageType);
		LOG.info("The url is : " + requestUrl);

		if (requestUrl.contains(ADDEMPLOYEE)) {
			LOG.info("The request url type is Add");
			doAdd(request, response);
		} else if (requestUrl.contains(VIEWEMPLOYEE)) {
			LOG.info("The request url type is View");
			doView(request, response);
		} else if (requestUrl.contains(SEARCHEMPLOYEE)) {
			LOG.info("The request url type is Search");
			doSearch(request, response);
		} else if ((pageType != null)) {
			LOG.info("The page type is page");
			if (pageType.contains(SEARCH)) {
				doSearch(request, response);
			} else if (pageType.contains(ADD)) {
				doAdd(request, response);
			} else if (pageType.contains(VIEW)) {
				doView(request, response);
			}
		}else if(update!=null){
			if(update.contains(UPDATE)){
				doAdd(request, response);
			}
		}
	}

	/**
	 * This method acts as controller for adding employee details in the
	 * database
	 * 
	 * @param request
	 *            {@link HttpServletRequest}
	 * @param response
	 *            {@link HttpServletResponse}
	 * @author nimesh
	 */
	protected void doAdd(HttpServletRequest request,
			HttpServletResponse response) {
		String actionType = (String) request.getAttribute("actionType");

		if (actionType == null) {

			employee = employeeAction.getEmployeeObject(request, response);
			boolean success = employeeServiceImpl
					.insertEmployeeDetails(employee);
			String buttonPressed = employee.getSubmitButton();
			request.setAttribute("success", success);
			if (success) {
				if (buttonPressed.matches(SUBMIT)) {

					// RequestDispatcher
					// dispatch=request.getRequestDispatcher(response.encodeURL(EmployeeConstants.VIEWPAGE));
					try {
						// dispatch.forward(request, response);
						response.sendRedirect(VIEWEMPLOYEE);
					} catch (IOException e) {
						LOG.severe("Error Occurred while dispatching request");
						LOG.severe("The message is " + e.getMessage());
					}
				} else if (buttonPressed.matches(SUBMITANDADD)) {
					// RequestDispatcher
					// dispatch=request.getRequestDispatcher(response.encodeURL(EmployeeConstants.ADDPAGE));
					try {
						// dispatch.forward(request, response);
						response.sendRedirect(ADDEMPLOYEE);
					} catch (IOException e) {
						LOG.severe("Error Occurred while dispatching request");
						LOG.severe("The message is " + e.getMessage());
					}
				}
			} else {
				// RequestDispatcher
				// dispatch=request.getRequestDispatcher(response.encodeURL(EmployeeConstants.VIEWPAGE));
				try {
					// dispatch.forward(request, response);
					response.sendRedirect(VIEWEMPLOYEE);
				} catch (IOException e) {
					LOG.severe("Error Occurred while dispatching request");
					LOG.severe("The message is " + e.getMessage());
				}
			}
		} else {
			int empId = (int) request.getAttribute("empId");
			employee = employeeAction.getEmployeeObject(request, response);
			boolean success = employeeServiceImpl.updateEmployeeDetail(
					employee, empId);
			try {
				 RequestDispatcher
					 dispatch=request.getRequestDispatcher(response.encodeURL(VIEWEMPLOYEE));
				 dispatch.forward(request, response);
				//response.sendRedirect(VIEWEMPLOYEE);
			} catch (IOException | ServletException e) {
				LOG.severe("Error Occurred while dispatching request");
				LOG.severe("The message is " + e.getMessage());
			}
		}
	}

	protected void doView(HttpServletRequest request,
			HttpServletResponse response) {
		String delete = request.getParameter("deleteButtonId");
		String edit = request.getParameter("editButtonId");
		int deleteId = 0;
		int editId = 0;
		if (!(delete == null)) {
			deleteId = Integer.parseInt(delete);
		}
		if (!(edit == null)) {
			editId = Integer.parseInt(edit);
		}

		if (!(deleteId == 0)) {
			employeeServiceImpl.deleteEmployee(deleteId);
			try {
				response.sendRedirect(VIEWEMPLOYEE);
			} catch (IOException e) {
				LOG.severe("Error Occurred while dispatching request");
				LOG.severe("The message is " + e.getMessage());
			}
		} else if (!(editId == 0)) {
			Employee employee = employeeServiceImpl.getEmployeeDetail(editId);
			request.setAttribute("editDetails", employee);
			request.setAttribute("empId", editId);
			RequestDispatcher dispatch = request.getRequestDispatcher(response
					.encodeURL(ADDEMPLOYEE));
			try {
				dispatch.forward(request, response);
			} catch (ServletException | IOException e) {
				LOG.severe("Error Occurred while dispatching request");
				LOG.severe("The message is " + e.getMessage());
			}
		}
	}

	protected void doSearch(HttpServletRequest request,
			HttpServletResponse response) {
		LOG.info("Into method doSearch()");
		String searchText = request.getParameter(SEARCHKEYWORD);
		String filterType = request.getParameter(FILTERTYPE);
		List<Employee> newEmployeeList = new ArrayList<Employee>();

		if (employeeList == null) {
			LOG.info("initializing employeeList");
			employeeList = employeeServiceImpl.searchEmployeeDetail(searchText,
					filterType);
			request.setAttribute("searchResult", employeeList);
			try {
				RequestDispatcher dispatch = request
						.getRequestDispatcher(response
								.encodeURL(SEARCHEMPLOYEE));
				dispatch.forward(request, response);
				// response.sendRedirect(SEARCHEMPLOYEE);
			} catch (IOException | ServletException e) {
				LOG.severe("Error occurred while dispatching request.");
				LOG.severe("The error message is " + e.getMessage());
			}
		}

		// if filter is applied and search is not.Filters data in already
		// searched result
		else if (((filterType != null) || !(filterType.equals("")))
				&& ((searchText == null || searchText.equals("") || searchText
				.contains("Enter")))) {
			for (Employee employee : employeeList) {
				if (employee.getDepartment().equalsIgnoreCase(filterType)) {
					newEmployeeList.add(employee);
				}
			}
			request.setAttribute("searchResult", newEmployeeList);
			
			try {
				RequestDispatcher dispatch = request.getRequestDispatcher(response
						.encodeURL(SEARCHEMPLOYEE));
				dispatch.forward(request, response);
			} catch (ServletException | IOException e) {
				LOG.severe("Error occurred while dispatching request.");
				LOG.severe("The error message is " + e.getMessage());
			}
		}

		else if (((filterType == null) || (filterType.equals("")))
				&& ((searchText != null || !(searchText.equals(""))))) {

			for (Employee employee : employeeList) {
				if (employee.getFirstName().contains(searchText)
						|| employee.getMiddleName().contains(searchText)
						|| employee.getLastName().contains(searchText)) {
					newEmployeeList.add(employee);
				}
			}
			request.setAttribute("searchResult", newEmployeeList);
			RequestDispatcher dispatch = request.getRequestDispatcher(response
					.encodeURL(SEARCHEMPLOYEE));
			try {
				dispatch.forward(request, response);
			} catch (ServletException | IOException e) {
				LOG.severe("Error occurred while dispatching request.");
				LOG.severe("The error message is " + e.getMessage());
			}
		}

	}
}
