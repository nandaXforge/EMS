//package ems;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(urlPatterns = "/displayemp")
//public class DisplayEmployeeServlet extends HttpServlet
//{
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
//	{
//		try 
//		{
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","5427");
//			Statement st=con.createStatement();
//			ResultSet rs1=st.executeQuery("select *from emp");
//			
//			req.setAttribute("rs1", rs1);
//			RequestDispatcher rd=req.getRequestDispatcher("allEmp.jsp");
//			rd.forward(req, resp);
//			
//			rs1.close();
//			st.close();
//			con.close();
//		} 
//		catch (ClassNotFoundException | SQLException e) 
//		{
//			e.printStackTrace();
//		}
//		
//
//	}
//}
