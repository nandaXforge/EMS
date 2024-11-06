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


@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
			PreparedStatement ps = con.prepareStatement("delete from emp where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		String msg = "Employee with ID : "+id+" Deleted Successfully";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from emp");
			req.setAttribute("rs", rs);
			req.setAttribute("msg", msg);
			RequestDispatcher rd = req.getRequestDispatcher("allemp.jsp");
			rd.include(req, resp);
		} 
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
