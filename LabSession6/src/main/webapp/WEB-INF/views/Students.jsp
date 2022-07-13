<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>

    <h2 align="center" style="background-color:#32CD32;"> Registration Table </h2>
	<table align="center">
		<tr>
			<td><a href="students/addStudent"><input type="button" value="Register New Student"/></a></td>
			<td><a href="/LabSession6/logout">Logout</a></td>
		</tr>
	</table>
	
	
	<h2 align="center" style="background-color:#32CD32;"> Display Table </h2>
	
	
	
	<table border="1" align="center" bgcolor="lightblue"  weight="70%" height="70%">
		<thead>
			<tr>
				<th>id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Country</th>
				<th>Course</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="students">
				<tr>
					<td>${students.student_id}</td>
					<td>${students.first_name}</td>
					<td>${students.last_name}</td>
					<td>${students.country}</td>
					<td>${students.course}</td>
					<td><a href="updateStudent?student_id=${students.student_id}">Update /</a> 
					<a href="deleteStudent?student_id=${students.student_id}">/ Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
