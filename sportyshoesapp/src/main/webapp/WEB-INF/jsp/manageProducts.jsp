<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Manage Products</h1>
	<form action="/products/productAdd" method="Post">
		<div style="margin-top: 1%; margin-left: 2%">
			Enter the product name : <input type="text" name="productName" />
		</div>
		<div style="margin-top: 1%; margin-left: 2%">
			Enter the product cost : <input type="text" name="productCost" />
		</div>
		<div style="margin-top: 1%; margin-left: 6%">
			Select Category :&nbsp; <select name="categorySelect">
				<c:forEach items="${categoryList}" var="category">
					<option value="${category.categoryId}">${category.categoryName}</option>
				</c:forEach>
			</select>
		</div>
		<div style="padding-top: 20px; margin-left: 15%;">
			<input type="submit" value="Submit">
		</div>
		<div style="color: red; margin-left: 1%;">
			<h5>${error}</h5>
		</div>
		<div style="padding-top: 20px">
			<table border="1" cellpadding="2" cellspacing="2">
				<thead>
					<tr class="tr tr-success">
						<td>Product Name</td>
						<td>Product Cost</td>
						<td>Category Name</td>
						<td>Update</td>
						<td>Delete</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productList}" var="product">
						<tr>
							<td>${product.productName}</td>
							<td>${product.cost}</td>
							<td>${product.category.categoryName}</td>
							<td><a id="linkId"
								href="<%=request.getContextPath()%>/products/findProduct/${product.productId}">Update</a>
							</td>
							<td><a id="linkId1"
								href="<%=request.getContextPath()%>/products/productDelete/${product.productId}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</form>
</body>
</html>