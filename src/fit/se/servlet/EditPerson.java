package fit.se.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import fit.se.beans.Person;
import fit.se.dao.PersonDAO;

public class EditPerson extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditPerson() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String country = req.getParameter("country");
		
		System.out.println("id " + id + "; name " + name +"; country " + country);
		PersonDAO personDAO = new PersonDAO();
		if(id == null || id.equalsIgnoreCase("")) {
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);
			return;
		} else if(name.equalsIgnoreCase("") || country.equalsIgnoreCase("")) {
			Person person = personDAO.getPerson(new Person(id, "", ""));
			if(person != null) {
				req.setAttribute("message", "Bạn phải nhập đầy đủ 2 thông tin");
				req.setAttribute("id", person.getId());
				req.setAttribute("name", person.getName());
				req.setAttribute("country", person.getCountry());
			}
		}
		else {
			personDAO.updatePerson(new Person(id, name, country));
			req.setAttribute("message", "Cập nhẩ thông tin thành công!");
		}
		RequestDispatcher rd = req.getRequestDispatcher("/edit.jsp");
		rd.forward(req, resp);
	}
}
