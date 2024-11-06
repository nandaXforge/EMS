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
import javax.servlet.http.HttpSession;

	@WebServlet(urlPatterns = "/login")
	public class LoginServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String email = req.getParameter("email");
			String password = req.getParameter("pass");
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "5427");

				PreparedStatement pstmt = con.prepareStatement("select * from emp where email =? and pass = ?");

				pstmt.setString(1, email);
				pstmt.setString(2, password);

				ResultSet rs = pstmt.executeQuery();
				PrintWriter pw = resp.getWriter();
				if (rs.next()) 
				{
					HttpSession session=req.getSession();
					session.setAttribute("name", rs.getString(2));
					session.setAttribute("email", rs.getString(3));
					session.setAttribute("pass", rs.getString(6));
					try 
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "5427");
						Statement stmt1 = con.createStatement();
						ResultSet rs1 = stmt1.executeQuery("select * from emp");
						pw.write("<html><body><h1 id =log>Logged In Successfully.....</h1></body></html>");
						req.setAttribute("rs1", rs1);
						RequestDispatcher rd = req.getRequestDispatcher("allEmp.jsp");
						rd.include(req, resp);
						rs1.close();
						stmt1.close();
						con1.close();
					} 
					catch (ClassNotFoundException | SQLException e) 
					{
						e.printStackTrace();
					}
				} 
				else 
				{
					pw.write("<html><body><h1 id =inv>Invalid Credientials</h1></body></html>");
					RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
					rd.include(req, resp);
				}
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}

		}

	}

