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
		<form action="/categoryApp/categoryUpdate/${category.categoryId}" method="Post">
			<div>
				Enter the category name : <input type="text" name="categoryName" value="${category.categoryName}"/>
			</div>
			<div>
				</br> <input type="submit" value="Submit">
			</div>
			<div style="color: red; margin-left: 1%;">
				<h5>${error}</h5>
			</div>
		</form>
	</div>
</body>
</html>