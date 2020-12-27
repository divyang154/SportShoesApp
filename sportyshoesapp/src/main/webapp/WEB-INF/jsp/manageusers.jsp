<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Users</title>
</head>
<body>
	<h1>Manage Users</h1>
	<div>
		<form action="/user/search" method="Post">
		<div>
			Enter the name of user to be searched : <input type="text" name="userToBeSearched" />
		</div>
		<div>
			</br> <input type="submit" value="Search">
		</div>
		<div style="color: red; margin-left: 1%;">
		<h5>${error}</h5>
		</div>
		</form>
		<div style="padding-top: 20px">
		<table border="1" cellpadding="2" cellspacing="2">
			<thead>
				<tr class="tr tr-success">
					<td>Username</td>
					<td>Password</td>
					<td>Email</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td>${user.userEmail}</td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
		</div>
	</div>
</body>
</html>