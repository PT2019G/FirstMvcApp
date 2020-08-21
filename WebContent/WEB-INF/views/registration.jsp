<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>

	<div>
		<h1>Registration Form</h1>
	</div>
	
	<form name='frm' action='submitregistrationdata' method='POST' enctype="multipart/form-data">
		Name: <input type='text' name='name' value=''
			style='width: 400px; height: 30px' /><br><br>
	  Email:  <input type='text' name='email' value=''
			style='width: 400px; height: 30px' /><br><br> 
	 Contact:  <input type='text' name='contact' value=''
	style='width: 400px; height: 30px' /><br><br> 
	 Address:  <input type='text' name='address' value=''
	style='width: 400px; height: 30px' /><br><br> 
	Upload Photo: <input type="file" name="photo"><br><br> 
	Username: <input type='text' name='username' value=''
			style='width: 400px; height: 30px' /><br><br>
	 Password:   <input type='password' name='password' value=''
			style='width: 400px; height: 30px' /><br><br> 
		
		<input type='submit' name='s' value='Register'
			style='width: 400px; height: 30px' /><br><br>
	</form>

</body>
</html>