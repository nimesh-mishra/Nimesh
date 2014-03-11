<%@page
	import="com.lftechnology.employee.controller.EmployeeControllerImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.lftechnology.employee.Department"%>
<%@page import="com.lftechnology.employee.service.EmployeeServiceImpl"%>
<%@page import="com.lftechnology.employee.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<script src='scripts.js'></script>
<link rel='stylesheet' type='text/css' href='styles.css'>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>Employee Management System</h1>
		</div>
		<div id="options-bar">
			<div id="view-option">
				<p>
					<a href="viewEmployee.jsp">View Employees</a>
				<p>
			</div>
			<div id="search-option">
				<p>
					<a href="searchEmployee.jsp">Search Employees</a>
				<p>
			</div>
		</div>
		<div id="add-employee-header">
			<h2><strong>Add Employee</strong></h2>
		</div>
		<div id="add-employee-form">
			<form action="EmployeeControllerServlet" method="post" id="addEmployee"
				name="addEmployee">
				<fieldset>
					<legend>
						<strong>Enter personal details here.</strong>
					</legend>
					
					<%Employee employee=(Employee)request.getAttribute("editDetails");%>
					<%if(employee==null){ %>
					
					<label> First Name</label> <input name='firstName' type='text'
						value='Enter First Name here' onclick='clearThis(this)'
						onfocus='clearThis(this)'><br> <label> Middle
						Name</label> <input name='middleName' type='text'
						value='Enter Middle Name here' onclick='clearThis(this)'
						onfocus='clearThis(this)'><br> <label> Last
						Name</label> <input name='lastName' type='text'
						value='Enter Last Name here' onclick='clearThis(this)'
						onfocus='clearThis(this)'><br> <label id="gender">Choose
						Gender</label> <input id='typeradio' type='radio' name='gender'
						value='male' checked>Male <input id='typeradio'
						type='radio' name='gender' value='female'>Female<br>
					<label> Age:</label> <input name='age' type='text'
						value='Enter Age here' onclick='clearThis(this)'
						onfocus='clearThis(this)'><br>
				</fieldset>
				<fieldset>
					<legend>
						<strong>Enter your location information</strong>
					</legend>
					<label>Country:</label> <input name='country' type='text'
						value='Nepal'><br> <label> Zone:</label> <input
						name='zone' type='text' value='Enter Zone here'
						onclick='clearThis(this)' onfocus='clearThis(this)'><br>
					<label> District:</label> <input name='district' type='text'
						value='Enter District here' onclick='clearThis(this)'
						onfocus='clearThis(this)'><br> <label>
						VDC/MNC:</label> <input name='vdcMnc' type='text'
						value='Enter VDC/MNC here' onclick='clearThis(this)'
						onfocus='clearThis(this)'><br>
				</fieldset>
				<%}else%><% { %>
				<%request.setAttribute("actionType", "update"); %>
				<%request.setAttribute("empId", request.getAttribute("empId")); %>
				<label> First Name</label> <input name='firstName' type='text'
                        value=<%=employee.getFirstName() %> onclick='clearThis(this)'
                        onfocus='clearThis(this)'><br> <label> Middle
                        Name</label> <input name='middleName' type='text'
                        value=<%=employee.getMiddleName() %> onclick='clearThis(this)'
                        onfocus='clearThis(this)'><br> <label> Last
                        Name</label> <input name='lastName' type='text'
                        value=<%=employee.getLastName() %> onclick='clearThis(this)'
                        onfocus='clearThis(this)'><br> <label id="gender">Choose
                        Gender</label> 
                        <%if(employee.getGender().equalsIgnoreCase("m")){ %>
                        <input id='typeradio' type='radio' name='gender'
                        value='male' checked>Male <input id='typeradio'
                        type='radio' name='gender' value='female'>Female<br>
                        <%}else { %>
                        <input id='typeradio' type='radio' name='gender'
                        value='male'>Male <input id='typeradio'
                        type='radio' name='gender' value='female' checked="checked">Female<br>
                        <%} %>
                    <label> Age:</label> <input name='age' type='text'
                        value=<%=employee.getAge() %> onclick='clearThis(this)'
                        onfocus='clearThis(this)'><br>
                </fieldset>
                <fieldset>
                    <legend>
                        <strong>Enter your location information</strong>
                    </legend>
                    <label>Country:</label> <input name='country' type='text'
                        value=<%=employee.getCountry() %>><br> <label> Zone:</label> <input
                        name='zone' type='text' value=<%=employee.getZone() %>
                        onclick='clearThis(this)' onfocus='clearThis(this)'><br>
                    <label> District:</label> <input name='district' type='text'
                        value=<%=employee.getDistrict() %> onclick='clearThis(this)'
                        onfocus='clearThis(this)'><br> <label>
                        VDC/MNC:</label> <input name='vdcMnc' type='text'
                        value=<%=employee.getVdcMnc() %> onclick='clearThis(this)'
                        onfocus='clearThis(this)'><br>
                </fieldset>
                <%} %>
				<fieldset>
                    <legend>Select your Department</legend>
                    <select name='dept'>
                        <%EmployeeControllerImpl controllerImpl = new EmployeeControllerImpl();%>
                        <%List<Department> department = controllerImpl.getDepartmentName();%>
                        <%
                            for (Department dept : department) {
                        %>
                        <option value="<%=dept.getDeptartmentName()%>"><%=dept.getDeptartmentName()%></option>
                        <%
                            }
                        %>
                    </select>
                </fieldset>
				<button type="submit" name="submitButton" value="submit"
					onclick="return validateForm()">Submit</button>
				<button type="submit" name="submitButton" value="submitAndAdd"
					onclick="return validateForm()">Submit And Add</button>
			</form>
		</div>
	</div>
</body>
</html>