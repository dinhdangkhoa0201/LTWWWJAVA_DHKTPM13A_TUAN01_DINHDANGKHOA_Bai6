<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>Edit Information</h1>
	<h3>Thông tin cũ</h3>
	<p>ID : ${id}</p>
	<p>Name : ${name}</p>
	<p>Country : ${country}</p>
	<form action="EditPerson" method="post">
		<table border="1">
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" value="${id}"></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Country :</td>
				<td><input type="text" name="country"></td>
			</tr>
		</table>
		<button type="submit">Edit</button>
	</form>
	<p style="color: red">${message}</p>
	<p>Come back <a href="index.jsp">Home!</a></p>
</body>

</html>