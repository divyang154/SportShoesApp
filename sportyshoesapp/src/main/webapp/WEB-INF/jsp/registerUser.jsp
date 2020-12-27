<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
</head>
<body>
	<h2>Register User</h2>
	<form action="/user/submitUser" method="Post">
		<div style="margin-top: 2%; margin-left: 2%">
			Enter the username : <input type="text" name="username" />
		</div>
		<div style="margin-top: 2%; margin-left: 2%">
			Enter the password : <input type="text" name="password" />
		</div>
		<div style="margin-top: 2%; margin-left: 4%">
			Enter the email : <input type="text" name="email" />
		</div>
		<div style="padding-top: 20px; margin-left: 15%;">
			<input type="submit" value="Submit">
		</div>
		<div style="color: red; margin-left: 1%;">
		<h5>${error}</h5>
		</div>
	</form>
</body>

</html>