<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
	<h1>Manage Category</h1>
	<div>
		<form action="/categoryApp/category" method="Post">
			<div>
				Enter the category name : <input type="text" name="categoryName" />
			</div>
			<div>
				</br> <input type="submit" value="Submit">
			</div>
			<div style="color: red; margin-left: 1%;">
				<h5>${error}</h5>
			</div>
		</form>
		<div style="padding-top: 20px">
			<table border="1" cellpadding="2" cellspacing="2">
				<thead>
					<tr class="tr tr-success">
						<td>Category Name</td>
						<td>Update</td>
						<td>Delete</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${categoryList}" var="category">
						<tr>
							<td>${category.categoryName}</td>
							<td><a id="linkId"
								href="<%=request.getContextPath()%>/categoryApp/findCategory/${category.categoryId}">Update</a>
							</td>
							<td><a id="linkId1"
								href="<%=request.getContextPath()%>/categoryApp/categoryDelete/${category.categoryId}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>