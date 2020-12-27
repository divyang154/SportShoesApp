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
	<h3>Update Product</h3>
	<div>
		<form action="/products/productsUpdate/${product.productId}"
			method="Post">
			<div style="padding-top: 20px; margin-left: 1%;">
				Enter the product name : <input type="text" name="productName"
					value="${product.productName}" />
			</div>
			<div style="padding-top: 20px; margin-left: 1%;" >
				Enter the product cost : <input type="text" name="productCost"
					value="${product.cost}" />
			</div>
			<div style="margin-top: 1%; margin-left: 6%">
				Select the product category :&nbsp; <select name="categorySelect">
					<c:forEach items="${categoryList}" var="category">
						<option value="${category.categoryId}" ${category.categoryId == product.category.categoryId ?'selected="selected"' : ''}>${category.categoryName}</option>
					</c:forEach>
				</select>
			</div>
			<div  style="margin-top: 1%; margin-left: 6%">
				</br> <input type="submit" value="Submit">
			</div>
			<div style="color: red; margin-left: 1%;">
				<h5>${error}</h5>
			</div>
		</form>
	</div>
</body>
</html>