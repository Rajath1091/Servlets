package servlets_hibernate_eb9_task_prc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets_hibernate_eb9_task_prc.dao.EmployeeDao;
import servlets_hibernate_eb9_task_prc.dto.Employee;

public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		EmployeeDao dao=new EmployeeDao();
		Employee employee=dao.getEmployee(id);
		PrintWriter out=resp.getWriter();
		if (employee.getId()==id && employee.getEmail().equals(email) && employee.getPassword().equals(password)) {
//			out.print("Logged In successful");
			RequestDispatcher dispatcher=req.getRequestDispatcher("success.html");
			dispatcher.forward(req, resp);
		}else {
//			out.print("Invalid Email & Password");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.forward(req, resp);
		}
	}
	
}
