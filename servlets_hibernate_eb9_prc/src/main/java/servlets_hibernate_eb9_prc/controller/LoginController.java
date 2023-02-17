package servlets_hibernate_eb9_prc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets_hibernate_eb9_prc.dao.PersonDao;

public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		PersonDao dao = new PersonDao();
		String dbPassword = dao.getPassword(email);
		PrintWriter out = resp.getWriter();
		if (dbPassword.equals(password)) {
//			out.print("Logged In successfully");
			
//			RequestDispatcher dispatcher=req.getRequestDispatcher("successfulLogin.html");
//			dispatcher.forward(req, resp);
			
			resp.sendRedirect("https://www.google.com/");
		} else {
//			out.print("Invalid Password");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.forward(req, resp);
		}
	}

}
