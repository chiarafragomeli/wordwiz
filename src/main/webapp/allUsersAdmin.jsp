<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Utenti</title>
<link rel="stylesheet" href="css/wordwiz.css">
</head>

<body>
<div>
		<a href="adminDashboard.jsp"><button>Dashboard</button></a>
	</div>
<ul>
		<c:forEach items="${user}" var="item">
			<li>${item.username}, ${item.email}</li>
		</c:forEach>
	</ul>

</body>
</html>