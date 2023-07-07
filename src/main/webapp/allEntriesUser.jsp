<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Glossary</title>
		</head>
		<link rel="stylesheet" href="css/wordwiz.css">

		<body class="dashboardBody">
			<div class="form-lemma">
				<div>
					<h1 class="entry-title"> MY GLOSSARY</h1>
				</div>
				<div>
					<ul class="list">
						<c:forEach items="${entries}" var="item">
							<li><a href="allentriesuser?id=${item.id}"></a> <strong>${item.word}</strong>,
								<em>${grammClasses[item.classId]}</em>:
								${item.description}</li>
						</c:forEach>
					</ul>
				</div>
				<div class="button-container">
					<a href="dashboard.jsp"><button class="CADSbutton">DASHBOARD</button></a>
				</div>
			</div>
		</body>

		</html>