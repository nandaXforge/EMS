<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome To EMS</title>
</head>
<body>
	<h1>Welcome To EMS</h1>
	<% response.sendRedirect("login.jsp"); %>
	<a href="register.jsp"><button>Register</button></a>
	<a href="displayemp"><button>View all Employees</button></a>
	<a href="login.jsp"><button>Login</button></a>
	<script type="text/javascript">
		let msgele=document.getElementById("msg");
		setTimeout(() => {
			msgele.style.cssText="display:none";
		}, 2000);
		
	</script>
</body>
</html>