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
	<h2>List of products purchased</h2>
	<form action="/purchase/purchaseProduct" method="Post">
		<div style="padding-top: 20px">
			<table border="1" cellpadding="2" cellspacing="2">
				<thead>
					<tr class="tr tr-success">
						<td>Product Name</td>
						<td>Product Cost</td>
						<td>Category Name</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productList}" var="product">
						<tr>
							<td>${product.productName}</td>
							<td>${product.cost}</td>
							<td>${product.category.categoryName}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
			<div align="center">
				Total Cost : <input type="text" readonly name="totalcost">
			</div>
		</div>
		<div style="padding-top: 20px">
			<input type="submit" value="Add To Cart">
		</div>
	</form>
</body>
</html>