package servlets_hibernate_student_prc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets_hibernate_student_prc.dao.StudentDao;
import servlets_hibernate_student_prc.dto.Student;

public class StudentController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String student_name = req.getParameter("student_name");
		String father_name = req.getParameter("father_name");
		String mother_name = req.getParameter("mother_name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		ServletContext context = getServletContext();
		String school = context.getInitParameter("school");

		ServletConfig config = getServletConfig();
		long fees = Long.parseLong(config.getInitParameter("fees"));

		Student student = new Student();
		student.setStudent_name(student_name);
		student.setFather_name(father_name);
		student.setMother_name(mother_name);
		student.setEmail(email);
		student.setPassword(password);
		student.setSchool(school);
		student.setFees(fees);

		StudentDao dao = new StudentDao();
		dao.saveStudent(student);

		RequestDispatcher dispatcher = req.getRequestDispatcher("success.html");
		dispatcher.forward(req, resp);
	}

}
