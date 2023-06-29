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
		<h1>Messaggi</h1>
	</header>
	<div>
		<a href="adminDashboard.jsp"><button>Dashboard</button></a>
	</div>
	<ul>
		<c:forEach items="${messages}" var="item">
			<li><a href="allmessagesadmin?id=${item.id}"></a>${item.message}, ${item.time}, ${item.sender_id}</li>	
		</c:forEach>
	</ul>
</body>
</html>