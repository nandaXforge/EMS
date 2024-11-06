<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"> 
    <title>Update Page</title>
    <style>
        body {
            height: 100%;
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
        }

        .container {
            margin: 50px auto;
            width: 50%;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .user, .password {
            margin-bottom: 15px;
            width: 100%;
        }

        input[type="text"], input[type="number"], input[type="tel"], input[type="password"] {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            border: none;
            color: white;
            text-transform: uppercase;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #45a049;
        }

        .form-group {
            width: 100%;
        }

        .form-group input {
            font-size: 16px;
        }

    </style>
</head>
<body>

    <%
        ResultSet rs = (ResultSet)request.getAttribute("rs");
    %>

    <h1>Update Employee</h1>
    <div class="container">
        <form action="update" method="post">
            <div class="form-group">
                <input type="number" value="<%= rs.getInt(1) %>" name="id" placeholder="Enter New ID" required />
            </div>
            <div class="form-group">
                <input type="text" value="<%= rs.getString(2) %>" name="fname" placeholder="Enter New Full Name" required />
            </div>
            <div class="form-group">
                <input type="tel" value="<%= rs.getString(3) %>" name="email" placeholder="Enter New Email" required />
            </div>
            <div class="form-group">
                <input type="number" value="<%= rs.getDouble(4) %>" name="salary" placeholder="Enter New Salary" required />
            </div>
            <div class="form-group">
                <input type="number" value="<%= rs.getInt(5) %>" name="deptno" placeholder="Enter New Dept Number" required />
            </div>
            <div class="form-group">
                <input type="password" value="<%= rs.getString(6) %>" name="pswd" placeholder="Enter New Password" required />
            </div>

            <button type="submit">Update</button>
        </form>
    </div>

</body>
</html>
