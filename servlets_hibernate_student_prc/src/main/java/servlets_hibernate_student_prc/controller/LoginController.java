package servlets_hibernate_student_prc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets_hibernate_student_prc.dao.StudentDao;
import servlets_hibernate_student_prc.dto.Student;

public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		ServletContext context = getServletContext();
		String school = context.getInitParameter("school");

		StudentDao dao = new StudentDao();
		Student student = dao.getStudent(id);

		if (id == student.getId() && school.equals(student.getSchool()) && email.equals(student.getEmail())
				&& password.equals(student.getPassword())) {
			resp.sendRedirect("https://stackoverflow.com/");
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
			dispatcher.forward(req, resp);
		}
	}

}
