<%@page import="com.lftechnology.employee.controller.EmployeeControllerImpl"%>
<%@page import="com.lftechnology.employee.Employee"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Employee Records</title>
<script src='scripts.js'></script>
<link rel='stylesheet' type='text/css' href='styles.css'>
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
            <div id="search-option">
                <p>
                    <a href="searchEmployee.jsp">Search Employees</a>
                <p>
            </div>
        </div>
        <div id="view-employee-header">
            <h2><strong>View Employee</strong></h2>
        </div>
         <%!EmployeeControllerImpl employeeControllerImpl=new EmployeeControllerImpl(); %>
            <%!List<Employee> employeeList=employeeControllerImpl.getEmployeeDetail(); %>
        <div id="view-table">
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
                <tbody>
                    <%for(Employee employee:employeeList){ %>
                        <tr>
                            <td><%=employee.getFirstName() %></td>
                            <td><%=employee.getMiddleName() %></td>
                            <td><%=employee.getLastName() %></td>
                            <td><%=employee.getGender() %></td>
                            <td><%=employee.getAge() %></td>
                            <td><%=employee.getCountry() %></td>
                            <td><%=employee.getZone() %></td>
                            <td><%=employee.getDistrict() %></td>
                            <td><%=employee.getVdcMnc() %></td>
                            <td><%=employee.getDepartment() %></td>
                            <td><input type="button" id=<%=employee.getId()%> class="viewButton" value="Edit" onclick="editRecord(<%=employee.getId()%>)"></td>
                            <td><input type="button" id=<%=employee.getId()%> class="viewButton" value="Delete" onclick="deleteRecord(<%=employee.getId()%>)"></td>
                        </tr>
                    <%} %>
                </tbody>
           </table>
        </div>
    </div>
</body>
</html>