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

/**
 * Servlet implementation class AddPerson
 */
@WebServlet(urlPatterns = {"/AddPerson"})
public class AddPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		PersonDAO personDAO = new PersonDAO();
		if(personDAO.addPerson(new Person(name, country)) == true) {
			request.setAttribute("message", "Thêm thành công");
			response.sendRedirect("ListPeople");
		}
	}

}
