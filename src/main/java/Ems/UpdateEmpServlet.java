package Ems;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/updtEmp")
public class UpdateEmpServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		double sal=Double.parseDouble(req.getParameter("sal"));
		int depNo=Integer.parseInt(req.getParameter("deptNo"));
		String pass=req.getParameter("pass");
		
		Connection con=null;
		PreparedStatement ps=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","5427");
			ps=con.prepareStatement("update emp set name=?,email=?,sal=?,deno=?,pass=? where id=?");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setDouble(3, sal);
			ps.setInt(4, depNo);
			ps.setString(5, pass);
			ps.setInt(6, id);
			int row=ps.executeUpdate();
			System.out.println(row+" row updated");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		PrintWriter pw=resp.getWriter();
		pw.write(
				"<html><body><h1 id=up>Employee details updated successfully</h1></body></html>"
				);
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","5427");
			Statement s=conn.createStatement();
			ResultSet rs=s.executeQuery("select *from emp");
			req.setAttribute("rs1",rs);
			RequestDispatcher rd=req.getRequestDispatcher("allEmp.jsp");
			rd.include(req, resp);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
}
