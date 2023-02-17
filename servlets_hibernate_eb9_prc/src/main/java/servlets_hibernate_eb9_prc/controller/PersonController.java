package servlets_hibernate_eb9_prc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import servlets_hibernate_eb9_prc.dao.PersonDao;
import servlets_hibernate_eb9_prc.dto.Person;

public class PersonController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String first_name = req.getParameter("first name");
		String last_name = req.getParameter("last name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));

		Person person = new Person();
		person.setFirst_name(first_name);
		person.setLast_name(last_name);
		person.setEmail(email);
		person.setPassword(password);
		person.setPhone(phone);

		PersonDao dao = new PersonDao();
//		dao.savePerson(person);
		dao.updatePerson(email, person);

		PrintWriter out = res.getWriter();
		out.print("Data updated successfully");
		
		
	}

}
