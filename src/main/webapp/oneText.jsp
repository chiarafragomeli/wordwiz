<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Text</title>
			<link rel="stylesheet" href="css/wordwiz.css">
		</head>

		<body class="dashboardBody">
			<div class="form-lemma">
				<div>
					<p>${text.author}, <em>${text.title}</em>: ${text.fragment}</p>
				</div>
				<div class="button-container">
					<a href="alltext"><button class="CADSbutton">CORPUS</button></a>
					<a href="dashboard.jsp"><button class="CADSbutton">DASHBOARD</button></a>
				</div>
			</div>

		</body>

		</html>