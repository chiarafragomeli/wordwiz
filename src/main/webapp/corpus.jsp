<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<title>WordWiz</title>
			<link rel="stylesheet" href="css/wordwiz.css">
		</head>

		<body class="dashboardBody">
			<div class="form-lemma">
				<div>
					<h1 class="entry-title">CORPUS</h1>
				</div>
				<form action="searchentry" method="get">
						<input name="entry" type="text" placeholder="Search">
						<button class="CADSbutton-search"><img src="img/searchicon.png" width="20"></button>
				</form>
				<div class="list">
					<ul>
						<c:forEach items="${text}" var="item">
							<li><a href="onetext?id=${item.id}">${item.author}, <em>${item.title}</em></a></li>
						</c:forEach>
					</ul>
				</div>

				<div class="button-container">
					<a href="dashboard.jsp"><button class="CADSbutton">DASHBOARD</button></a>
				</div>
			</div>
		</body>

		</html>