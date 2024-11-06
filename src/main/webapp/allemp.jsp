<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employee Data</title>
<link rel="stylesheet" href="./allEmp.css">
</head>
<body>
	<h1>All Employees</h1>
	<h2><%= session.getAttribute("name")%></h2>
	<h2><% session.invalidate();%></h2>
	<a href="register.jsp" class="reg"><button>Register</button></a>
	<table>
		<tr>
			<th>S.No</th>
			<th>ID</th>
			<th class="name">Name</th>
			<th class="email">Email</th>
			<th>Salary</th>
			<th>DeptNo.</th>
			<th>Password</th>
			<th colspan="2">Action</th>
		</tr>
	<%
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","5427");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select *from emp");
		int i=1;
		while(rs.next())
		{
	%>
		<tr>
			<td><%= i++%></td>
			<td><%= rs.getInt(1)%></td>
			<td><%= rs.getString(2)%></td>
			<td><%= rs.getString(3)%></td>
			<td><%= rs.getDouble(4)%></td>
			<td><%= rs.getInt(5)%></td>
			<td><%= rs.getString(6) %></td>
			<td><a href="delEmp?id=<%= rs.getInt(1)%>"><button>Delete</button></a></td>	
			<td><a href="updateEmp.jsp?id=<%= rs.getInt(1)%>"><button>Update</button></a></td>		
		<tr>
	<%
		}
	%>
	</table>
	
	<a href="login.jsp" class="reg"><button>LogOut</button> </a>
		<script type="text/javascript">
				let dele=document.getElementById("del");
				setTimeout(() => {
				dele.style.cssText="display:none";
				}, 2000);
			
				let upd=document.getElementById("up");
				setTimeout(() => {
				upd.style.cssText="display:none";
				}, 2000);
				
				let log=document.getElementById("log");
				setTimeout(() => {
				log.style.cssText="display:none";
				}, 2000);
		</script>
</body>
</html>