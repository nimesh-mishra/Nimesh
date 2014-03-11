<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<link rel='stylesheet' type='text/css' href='styles.css'>
<style type="text/css" >
a{
text-decoration: none;
    text-align: center;
    font-size: 30px;
    font-family: sans-serif;
    color:#8c3e40;
}
</style>
</head>
<body>
    <div id="index-wrapper">
    <h1 id="index-h1"><strong>Welcome to Employee Management System</strong></h1>
        <div id="index-option">
            <div id="index-view-option">
                <p>
                    <strong><a href="viewEmployee.jsp" id="index-link">View Employees</a></strong>
                <p>
            </div>
            <div id="index-add-option">
                <p>
                    <strong><a href="addEmployee.jsp" id="index-link">Add Employees</a></strong>
                <p>
            </div>
            <div id="index-search-option">
                <p>
                    <strong><a href="searchEmployee.jsp" id="index-link">Search Employees</a></strong>
                <p>
            </div>
        </div>
    </div>
</body>
</html>