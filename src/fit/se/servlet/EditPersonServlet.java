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

@WebServlet(urlPatterns = {"/EditPerson"})
public class EditPersonServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditPersonServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String country = req.getParameter("country");
		PersonDAO personDAO = new PersonDAO();
		if(personDAO.updatePerson(new Person(id, name, country)) == true) {
			resp.sendRedirect("ListPeople");
		}
	}
}
