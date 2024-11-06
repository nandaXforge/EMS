//package ems;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(urlPatterns = "/updatePage")
//public class UpdatePageServlet extends HttpServlet
//{
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
//	{
//		int id=Integer.parseInt(req.getParameter("id"));
//		Connection con=null;
//		PreparedStatement ps=null;
//		try 
//		{
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","5427");
//			ps=con.prepareStatement("select *from emp where id=?");
//			ps.setInt(1, id);
//			ResultSet rs=ps.executeQuery();
//			if(rs.next())
//			{
//				req.setAttribute("rs",rs);
//				RequestDispatcher rd=req.getRequestDispatcher("updateEmp.jsp");
//				rd.forward(req, resp);
//			}
//		} 
//		catch (ClassNotFoundException | SQLException e) 
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			if(con!=null)
//			{
//				try 
//				{
//					con.close();
//				} 
//				catch (SQLException e) 
//				{
//					e.printStackTrace();
//				}
//			}
//			if(ps!=null)
//			{
//				try 
//				{
//					ps.close();
//				} 
//				catch (SQLException e) 
//				{
//					e.printStackTrace();
//				}
//			}
//		}
//
//	}
//}
