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
		<a href="dashboard.jsp"><button>Dashboard</button></a>
	</div>
	<form class="form-inline my-2 my-lg-0">
		<input class="form-control mr-sm-2" type="search" placeholder="Search">
		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	</form>
	<ul>
		<c:forEach items="${text}" var="item">
			<li><a href="onetext?id=${item.id}">${item.author}, ${item.title}</a></li>	
		</c:forEach>
	</ul>
</body>
</html>