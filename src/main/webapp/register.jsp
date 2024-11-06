<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<link rel="stylesheet" href="./register.css">
</head>
<body>
	<h1>Fill the form to Register</h1>
	<h2><%= session.getAttribute("name")%></h2>
    <form action="reg" method="post">
    	<input type="number" name="id" placeholder="Enter ID">	
        <input type="text" name="name" placeholder="Enter Full Name">
		<input type="email" name="email" placeholder="Enter email">
		<input type="number" name="sal" placeholder="Enter Salary">
        <input type="number" name="deptNo" placeholder="Enter Dept No.">
        <input type="password" name="pass" placeholder="Enter Password">
		<button type="submit">Register</button>
	</form>
</body>
</html>