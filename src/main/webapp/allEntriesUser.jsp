<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wordwiz</title>
</head>
<link rel="stylesheet" href="css/wordwiz.css">
<body>
	<header>
		<h1>I miei lemmi</h1>
	</header>
	<p>Classi: ${grammClasses}</p>
	<div>
		<a href="dashboard.jsp"><button>Dashboard</button></a>
	</div>
	<ul>
		<c:forEach items="${entries}" var="item">
			<li><a href="allentriesuser?id=${item.id}"></a>${item.word}, ${grammClasses[item.classId]}, ${item.description}</li>	
		</c:forEach>
	</ul>
</body>
</html>