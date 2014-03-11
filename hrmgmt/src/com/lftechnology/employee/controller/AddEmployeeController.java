package com.lftechnology.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lftechnology.employee.Employee;
import com.lftechnology.employee.EmployeeActionUtil;
import com.lftechnology.employee.EmployeeConstants;
import com.lftechnology.employee.service.EmployeeServiceImpl;

/**
 * Servlet implementation class AddEmployeeController
 */
@WebServlet("/AddEmployeeController")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeActionUtil employeeAction;
	private Employee employee;
	private EmployeeServiceImpl employeeServiceImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeController() {
    	employeeAction=new EmployeeActionUtil();
    	employee=new Employee();
    	employeeServiceImpl=new EmployeeServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employee=employeeAction.getEmployeeObject(request, response);
		boolean success=employeeServiceImpl.insertEmployeeDetails(employee);
		String buttonPressed=employee.getSubmitButton();
		request.setAttribute("success", success);
		if(success){
			if(buttonPressed.matches("submit")){
				
				RequestDispatcher dispatch=request.getRequestDispatcher(response.encodeURL(EmployeeConstants.VIEWPAGE));
				dispatch.forward(request, response);
			}
			else if(buttonPressed.matches("submitAndAdd")){
				RequestDispatcher dispatch=request.getRequestDispatcher(response.encodeURL(EmployeeConstants.ADDPAGE));
				dispatch.forward(request, response);
			}
		}
		else{
			RequestDispatcher dispatch=request.getRequestDispatcher(response.encodeURL(EmployeeConstants.VIEWPAGE));
			dispatch.forward(request, response);
		}
		
	}

}
