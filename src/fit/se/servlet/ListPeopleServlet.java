package fit.se.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.se.beans.Person;
import fit.se.dao.PersonDAO;

@WebServlet(urlPatterns = {"/", "/ListPeople"})
public class ListPeopleServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PersonDAO personDAO = new PersonDAO();
		List<Person> people = personDAO.getPeople();
		String html = "";
		
		html += "<!DOCTYPE html>" + 
				"" + 
				"<html>" + 
				"" + 
				"<head>" + 
				"	<meta charset='UTF-8'>" + 
				"	<meta name='viewport' content='width=device-width, initial-scale=1.0'>" + 
				"	<title>LTWWWJAVA_DHKTPM13A_TUAN01_DINHDANGKHOA_Bai6</title>" + 
				"</head>" + 
				"	<script type='text/javascript'>" + 
				"			function submitForm(){" + 
				"				var result = confirm('Bạn có chắc chắn khi XOÁ thông tin này?');" + 
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
				"	<h1>Bài 6</h1>" + 

				"	<p style='color: #f02;'>Java Servlet – Thao tác với CSDL (có thể" + 
				"		dùng JPA với OGM MongoDB hoặc kết nối trực tiếp vào MongoDB)</p>" + 
				"	<form action='AddPerson' method='POST' name='addPerson'>" + 
				"		<table>" + 
				"			<tr>" + 
				"				<td>Name :</td>" + 
				"				<td>"+ 
				"					<input type='text' name='name' id='name' />" + 
				"				</td>" + 
				"			</tr>" + 
				"			<tr>" + 
				"				<td>Country :</td>" + 
				"				<td>" + 
				"					<input type='text' name='country' id='country' />" + 
				"				</td>" + 
				"			</tr>" + 
				"		</table>" + 
				"		<button type='submit'>Add Person</button>" + 
				"		<br>" + 
				"	</form>" + 
				"	<div>" + 
				"		<table border='1' id='data' style='align-items: center;'>" + 
				"			<tr>" + 
				"				<th>ID</th>" + 
				"				<th>Name</th>" + 
				"				<th>Country</th>" + 
				"				<th>Edit</th>" + 
				"				<th>Delete</th>" + 
				"			</tr>";
		for(int i = 0; i < people.size(); i++) {
			html += "<tr>";
				html += "<td>" + people.get(i).getId() + "a</td>";
				html += "<td>" + people.get(i).getName() + "</td>";
				html += "<td>" + people.get(i).getCountry() + "</td>";
				html += "<td><a href='FormPerson?id=" + people.get(i).getId() + "'>Edit</a></td>";
				html += "<td><a href='DeletePerson?id="+ people.get(i).getId() + "' onclick='submitForm()'>Delete</a></td>";
			html += "</tr>";
		}

		html += "		</table>" + 
				"" + 
				"	</div>" + 
				"</body>" + 
				"" + 
				"</html>";
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(html);
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
