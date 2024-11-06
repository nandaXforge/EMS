package Ems;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/reg")
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String sal=req.getParameter("sal");
		String deptNo=req.getParameter("deptNo");
		String pass=req.getParameter("pass");
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","5427");
			PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?,?,?,?)");
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setDouble(4, Double.parseDouble(sal));
			ps.setInt(5, Integer.parseInt(deptNo));
			ps.setString(6, pass);
			int row=ps.executeUpdate();
			System.out.println(row+" row inserted");
			ps.close();
			con.close();
			PrintWriter pw= resp.getWriter();
			//+"<h1 style='text-align:center'><a href=register.html>Click here to go to registration form</a></h1>"
			pw.write(
					"<html><body>"
					+"<h1 style='text-align:center' id=msg>Registration Successful</h1>"
					+"</body></html>"
					);
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.include(req, resp);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}
}
