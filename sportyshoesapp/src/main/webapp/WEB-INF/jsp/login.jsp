<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center" style="padding-top: 20px">
		<h3>
			<u>Sport Shoes Login</u>
		</h3>
		<form action="/login/authenticate" method="Post">
			<div align="center">
				<input type="text" name="username" placeholder="Enter Username">
			</div>
			<div align="center" style="padding-top: 20px">
				<input type="password" name="password" placeholder="Enter Password">
			</div>
			<div style="padding-top: 20px">
				<input type="submit" value="Login">
			</div>
		</form>
		<div style="padding-top: 30px">
			<a id="linkId"
				href="<%=request.getContextPath()%>/user/register">Register as User</a>
		</div>
		<div style="color: red;">${error}</div>
	</div>
</body>
</html>