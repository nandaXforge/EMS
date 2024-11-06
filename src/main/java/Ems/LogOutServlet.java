//package ems;
//
//import java.io.IOException;
//import java.net.Authenticator.RequestorType;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebServlet(urlPatterns = "/logout")
//public class LogOutServlet extends HttpServlet
//{
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
//	{
//		HttpSession session=req.getSession();
//		session.invalidate();
//		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
//		rd.forward(req, resp);
//	}
//}
