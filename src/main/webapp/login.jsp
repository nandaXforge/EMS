<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./register.css">
</head>
<body>
		<h1>Login</h1>
		<h2><%= session.getAttribute("name")%></h2>
		<% session.invalidate();%>
    	<form action="login" method="get">
			<input type="email" name="email" placeholder="Enter email">
        	<input type="password" name="pass" placeholder="Enter Password">
			<button type="submit">Login</button>
		</form>
	
			<script type="text/javascript">
				let inv=document.getElementById("inv");
				setTimeout(() => {
				inv.style.cssText="display:none";
				}, 2000);
			</script>
</body>
</html>