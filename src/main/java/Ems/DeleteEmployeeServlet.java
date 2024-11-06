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

@WebServlet(urlPatterns = "/delEmp")
public class DeleteEmployeeServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("id"));
		Connection con=null;
		PreparedStatement ps=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","5427");
			ps=con.prepareStatement("delete from emp where id=?");
			ps.setInt(1, id);
			int row=ps.executeUpdate();
			System.out.println(row+" row deleted..");			
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
		PrintWriter pw= resp.getWriter();
		pw.write(
				"<html><body>"
				+"<h1 style='text-align:center' id=del>Requested Data Deleted with id : "+id+"</h1>"
				+"</body></html>"
				);
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","5427");
			Statement s=conn.createStatement();
			ResultSet rs=s.executeQuery("select *from emp");
			req.setAttribute("rs",rs);
			RequestDispatcher rd=req.getRequestDispatcher("allEmp.jsp");
			rd.include(req, resp);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
}
