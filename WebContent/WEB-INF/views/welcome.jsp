<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<h1>
		Welcome &nbsp;
		<c:out value="${username}" />
	</h1>

	<a href="<c:url value="/viewDetails/${username}" />">View Profile</a>

	<br>
	<br>
	<c:if test="${not empty u}">

		<table border="1">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Contact</th>
				<th>Address</th>
				<th>Photo</th>
			</tr>
			<tr>
				<td><c:out value="${u.name}" /></td>
				<td><c:out value="${u.email}" /></td>
				<td><c:out value="${u.contact}" /></td>
				<td><c:out value="${u.address}" /></td>
				<td><img width="100" height="100"
					src="<c:url value="/getProfilePhoto/${u.id}" />"></td>
			</tr>

		</table>

	</c:if>


</body>
</html>