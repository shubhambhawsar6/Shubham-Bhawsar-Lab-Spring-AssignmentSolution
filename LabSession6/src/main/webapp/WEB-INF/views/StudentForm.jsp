<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>College Student list Update </title>
</head>
<body>

    <h2 style="background-color:#32CD32;" align="center">Registration Table</h2>
	<form action="save" method="post">
		<table align="center">
			<tr>
				<td>FirstName</td>
				<td><input type="text" value="${students.first_name}"
					name="first_name" /></td>
			</tr>
			<tr>
			<tr>
				<td>LastName</td>
				<td><input type="text" value="${students.last_name}"
					name="last_name" /></td>
			</tr>
			<tr>
			<tr>
				<td>Country</td>
				<td><input type="text" value="${students.country}"
					name="country" /></td>
			</tr>
			<tr>
				<td>Course</td>
				<td><input type="text" value="${students.course}"
					name="course" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" value="${students.student_id}"
					name="student_id" /><input type="submit" /></td>
					
			</tr>
			<tr><td><a href="list">Back to List</a></td></tr>

		</table>
	</form>
</body>
</html>