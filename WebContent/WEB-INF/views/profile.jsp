<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<br>
	<br>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Contact</th>
			<th>Address</th>
			<th>Photo</th>
		</tr>
		<c:forEach items="${regList}" var="r">
			<tr>
				<td><c:out value="${r.name}" /></td>
				<td><c:out value="${r.email}" /></td>
				<td><c:out value="${r.contact}" /></td>
				<td><c:out value="${r.address}" /></td>
				<td><img width="100" height="100" src="getStudentPhoto/<c:out value='5'/>"></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>