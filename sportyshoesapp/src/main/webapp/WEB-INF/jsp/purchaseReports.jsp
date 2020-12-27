<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Purchase Reports</h1>
	<form action="/purchase/searchPurchaseReport" method="Post">
		<div style="margin-top: 1%; margin-left: 6%">
			Select Category :&nbsp; <select name="categorySelect">
				<c:forEach items="${categoryList}" var="category">
					<option value="${category.categoryId}">${category.categoryName}</option>
				</c:forEach>
			</select>
		</div>
		<div style="margin-top: 1%">
			<span style="margin-left: 6%;"> Please enter date: </span><span><input
				type="date" name="dateSelected" placeholder="Enter date of travrl" value="selectedDate"></span>
		</div>
		<div style="margin-top: 1%; margin-left: 6%">
			<input type="submit" value="Search">
		</div>
	</form>
	<div style="padding-top: 20px">
		<table border="1" cellpadding="2" cellspacing="2">
			<thead>
				<tr class="tr tr-success">
					<td>Purchase Order No</td>
					<td>Purchase Date</td>
					<td>UserName</td>
					<td>Details Of Products Purchased</td>
					<td>Total Cost</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${purchaseList}" var="purchase">
					<tr>
						<td>${purchase.purchaseId}</td>
						<td>${purchase.dateOfPurchase}</td>
						<td>${purchase.user.username}</td>
						<td>${purchase.product}</td>
						<td>${purchase.totalCost}</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>
</body>
</html>