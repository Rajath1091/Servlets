package servlets_eb9_prc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SumClass extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String num1=req.getParameter("num1");
		String num2=req.getParameter("num2");
		int n1=Integer.parseInt(num1);
		int n2=Integer.parseInt(num2);
		PrintWriter out=res.getWriter();
		out.print(n1+n2);
	}

}
