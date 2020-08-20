<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<div>
		<h1>Login Form</h1>
	</div>
	<form name='frm' action='welcome' method='POST'>
		<input type='text' name='username' value=''
			style='width: 400px; height: 30px' /><br><br>
	    <input type='password' name='password' value=''
			style='width: 400px; height: 30px' /><br><br> 
		<input type='submit' name='s' value='Login'
			style='width: 400px; height: 30px' /><br><br>
			
		 <a href='/FirstMvcApp/registration'>Register page</a>
	</form>
</body>
</html>