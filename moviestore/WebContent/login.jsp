<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<div id="wrapper">
		<h1>
			<a href="index.jsp">Movie Store</a>
		</h1>
		<div id="signup">
		  <form action="LoginCheckServlet" method="post">
		      <fieldset id="login-form-fieldset">
		          <legend>Sign In</legend>
		          <label for="username">UserName :  </label>
		          <input type="text" id="username" name="userName" value="Enter User Name Here" autofocus onclick="this.value=''"><br><br>
		          <label for="pass">Password :  </label>
		          <input type="password" id="pass" name="password" value="Enter Password Here" onclick="this.value=''"><br><br>
		          <input type="submit" value="Log In" >
		      </fieldset>
		  </form>
		</div>
	</div>
</body>
</html>