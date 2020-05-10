package fit.se.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.se.beans.Person;
import fit.se.dao.PersonDAO;

public class ForwardEdit extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ForwardEdit() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonDAO personDAO = new PersonDAO();
		String id = req.getParameter("idPerson");
		Person person = personDAO.getPerson(new Person(id, "", ""));
		req.setAttribute("id", id);
		req.setAttribute("name", person.getName());
		req.setAttribute("country", person.getCountry());
		RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
		rd.forward(req, resp);
	}
}
