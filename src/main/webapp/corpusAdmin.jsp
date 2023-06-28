<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>WordWiz</title>
<link rel="stylesheet" href="css/wordwiz.css">
</head>

<body>
	<header>
		<h1>Corpus</h1>
	</header>
	<div>
		<a href="adminDashboard.jsp"><button>Dashboard</button></a>
	</div>
	
	<ul>
		<c:forEach items="${text}" var="item">
			<li><a href="alltextadmin?id=${item.id}">${item.author}, ${item.title}</a></li>	
		</c:forEach>
	</ul>
</body>
</html>