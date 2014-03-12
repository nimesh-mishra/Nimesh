<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lftechnology.employee.Employee"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='scripts.js'></script>
<link rel='stylesheet' type='text/css' href='styles.css'>
<title>Search Employee</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>Employee Management System</h1>
		</div>
		<div id="options-bar">
			<div id="add-option">
				<p>
					<a href="addEmployee.jsp">Add Employees</a>
				<p>
			</div>
			<div id="view-option">
				<p>
					<a href="viewEmployee.jsp">View Employees</a>
				<p>
			</div>
		</div>
		<div id="search-box">
			<form id="search-form" action="EmployeeControllerServlet"
				method="post">
				<input type="text" value="Enter keyword here..."
					name="searchKeyword" onclick='clearThis(this)'
					onfocus='clearThis(this)'> 
					<input type="submit"value="Search"> Filter By: <select name="filterType"
					onchange="this.form.submit()">
					<option value="" selected="selected">Select</option>
					<option value="Java">Java</option>
					<option value="QA">QA</option>
					<option value="Database">Database</option>
					<option value="DevOPS">DevOPS</option>
					<option value="HR">HR</option>
				</select>
				<input type="hidden" name="search" value="search">
			</form>
		</div>
		<div id="search-table">
			<table>
				<thead>
					<tr>
						<th>First Name</th>
						<th>Middle Name</th>
						<th>Last Name</th>
						<th>Gender</th>
						<th>Age</th>
						<th>Country</th>
						<th>Zone</th>
						<th>District</th>
						<th>Vdc/Mnc</th>
						<th>Department</th>
					</tr>
					<tr></tr>
				</thead>
				<%!List<Employee> employeeList = new ArrayList<Employee>();%>
				<%
                    employeeList = (List) request.getAttribute("searchResult");
                %>
				<%
					if (!(employeeList == null)) {
				%>
				<tbody>
					<%
						request.setAttribute("pageType", "search");
					%>
					<%
						for (Employee employee : employeeList) {
					%>
					<tr>
						<td><%=employee.getFirstName()%></td>
						<td><%=employee.getMiddleName()%></td>
						<td><%=employee.getLastName()%></td>
						<td><%=employee.getGender()%></td>
						<td><%=employee.getAge()%></td>
						<td><%=employee.getCountry()%></td>
						<td><%=employee.getZone()%></td>
						<td><%=employee.getDistrict()%></td>
						<td><%=employee.getVdcMnc()%></td>
						<td><%=employee.getDepartment()%></td>
						
					</tr>
					<%
						}
					%>
				</tbody>
				<%
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>