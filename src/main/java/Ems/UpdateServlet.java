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

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends  HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String  fname= req.getParameter("fname");
		String email = req.getParameter("email");
		double salary = Double.parseDouble(req.getParameter("salary"));
		int deptno= Integer.parseInt(req.getParameter("deptno"));
		String  pswrd= req.getParameter("pswd");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
			PreparedStatement pstmt = con.prepareStatement("update emp set name =? ,email=?,salary=?,deptno=?,password=? where id =?");
			
			
			pstmt.setString(1, fname);
			pstmt.setString(2, email);
			pstmt.setDouble(3, salary);
			pstmt.setInt(4, deptno);
			pstmt.setString(5, pswrd);
			pstmt.setInt(6,id);
			
			
			int rows = pstmt.executeUpdate();
			System.out.println(rows+" row is updated ");
			pstmt.close();
			con.close();
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		PrintWriter pw = resp.getWriter();
		pw.write("<html><body><h1 id =msg>Employeee Updated Succesfully</h1> </body> </html>");
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp");
			req.setAttribute("rs", rs);
			
			RequestDispatcher rd = req.getRequestDispatcher("allemp.jsp");
			rd.include(req, resp);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
