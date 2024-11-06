<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
<link rel="stylesheet" href="./register.css">
</head>
<body>
	<%
	int id=Integer.parseInt(request.getParameter("id"));
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","5427");
		ps=con.prepareStatement("select *from emp where id=?");
		ps.setInt(1, id);
		rs=ps.executeQuery();
		rs.next();
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	%>
	<h1>Update Page</h1>
	<h2><%= session.getAttribute("name")%></h2>
	   <form action="updtEmp" method="post">
    		<input type="number" value="<%= rs.getInt(1)%>" name="id" placeholder="Enter ID">	
        	<input type="text" value="<%= rs.getString(2)%>" name="name" placeholder="Enter Full Name">
			<input type="email" value="<%= rs.getString(3)%>" name="email" placeholder="Enter email">
			<input type="number" value="<%= rs.getDouble(4)%>" name="sal" placeholder="Enter Salary">
        	<input type="number" value="<%= rs.getInt(5)%>" name="deptNo" placeholder="Enter Dept No.">
        	<input type="password" value="<%= rs.getString(6)%>" name="pass" placeholder="Enter Password">
			<button type="submit">Update</button>
		</form>
</body>
</html>