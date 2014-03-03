package com.lftechnology.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet class is used to check the login credentials of the user
 * @author nimesh
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * This is the default constructor.
     * @author nimesh
     */
    public LoginCheckServlet() {
        super();
    }

	/**
	 * This method is used to intercept get requests.
	 * @param request {@link HttpServletRequest} The object containing request data.
	 * @param response {@link HttpServletResponse} The object that will contating response data.
	 * @author nimesh
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * This method is used to intercept post requests.
	 * This method checks the user's username and password.
	 * @param request {@link HttpServletRequest} The object containing request data.
	 * @param response {@link HttpServletResponse} The object that will contating response data.
	 * @author nimesh
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
	}

}
