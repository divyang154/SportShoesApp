<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Panel</title>
</head>
<body>
	<h1>Admin Panel</h1>
	<h3>You can navigate to following pages</h3>
	<div>
		<a id="linkId" href="<%=request.getContextPath()%>/categoryApp">Manage
			Categories</a>
	</div>
	<div>
		<a id="linkId" href="<%=request.getContextPath()%>/products">Manage
			Product</a>
	</div>
	<div>
		<a id="linkId" href="<%=request.getContextPath()%>/user">Manage
			Users</a>
	</div>
	<div>
		<a id="linkId" href="<%=request.getContextPath()%>/purchase/purchaseReports">View
			Purchase Report</a>
	</div>
</body>
</body>
</html>