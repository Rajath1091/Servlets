package servlets_hibernate_eb9_task_prc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets_hibernate_eb9_task_prc.dao.EmployeeDao;
import servlets_hibernate_eb9_task_prc.dto.Employee;

public class EmployeeController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		long phone=Long.parseLong(req.getParameter("phone"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Employee employee=new Employee();
		employee.setName(name);
		employee.setAddress(address);
		employee.setPhone(phone);
		employee.setEmail(email);
		employee.setPassword(password);
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		employee.setId(id);
		
		EmployeeDao dao=new EmployeeDao();
//		dao.saveEmployee(employee);
		dao.updateEmployee(id, employee);
		
		PrintWriter out=resp.getWriter();
//		out.print("Data saved successfully");
		out.print("Data updated successfully");
	}
	
}
