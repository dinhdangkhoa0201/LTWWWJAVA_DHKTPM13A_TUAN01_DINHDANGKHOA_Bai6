package fit.se.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.se.beans.Person;
import fit.se.dao.PersonDAO;

@WebServlet(urlPatterns = {"/DeletePerson"})
public class DeletePersonServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DeletePersonServlet() {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		PersonDAO personDAO = new PersonDAO();
		if(personDAO.deletePerson(new Person(id, "", "")) == true) {
			resp.sendRedirect("ListPerson");
		}
	}
}
