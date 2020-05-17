package fit.se.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.se.beans.Person;
import fit.se.dao.PersonDAO;

@WebServlet(urlPatterns = {"/FormPerson"})
public class FormPersonServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FormPersonServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		PersonDAO personDAO = new PersonDAO();
		Person person = personDAO.getPerson(new Person(id, "", ""));
		
		String html = "";
		html += "<!DOCTYPE html>" + 
				"<html>" + 
				"" + 
				"<head>" + 
				"<meta charset=\"UTF-8\">" + 
				"<title>Insert title here</title>" + 
				"</head>" + 
				"	<script type='text/javascript'>" + 
				"			function submitForm(){" + 
				"				var result = confirm('Bạn có chắc chắn khi CẬP NHẬT thông tin này?');" + 
				"				if(result == true){" + 
				"					return true" + 
				"				} else { "+ 
				"					event.stopPropagation(); " +
				"					event.preventDefault();" + 
				"				}" + 
				"			}" + 
				"	</script>" +
				"" + 
				"<body>" + 
				"	<h1>Edit Information</h1>" + 
				"	<form action=\"EditPerson\" method=\"post\">" + 
				"		<table border=\"1\">" + 
				"			<tr>" + 
				"				<td>ID</td>" + 
				"				<td><input type=\"text\" name=\"id\" value=\"" + person.getId() + "\" readonly></td>" + 
				"			</tr>" + 
				"			<tr>" + 
				"				<td>Name :</td>" + 
				"				<td><input type=\"text\" name='name' value=\"" + person.getName() + "\" /></td>" + 
				"			</tr>" + 
				"			<tr>" + 
				"				<td>Country :</td>" + 
				"				<td><input type=\"text\" name='country' value=\"" + person.getCountry() + "\"></td>" + 
				"			</tr>" + 
				"		</table>" + 
				"		<button type=\"submit\" onclick='submitForm()'>Edit</button>" + 
				"	</form>" + 
				"	<p>Come back <a href=\"ListPeople\">Home!</a></p>" + 
				"</body>";
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(html);
		out.close();
	}
}
