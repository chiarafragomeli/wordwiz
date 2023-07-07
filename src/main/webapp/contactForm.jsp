<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<title>Contact form</title>
			<link rel="stylesheet" href="css/wordwiz.css">
		</head>

		<body class="dashboardBody">
			<div class="form-lemma" align="center">
				<div class="entry-title">
					<h1>CONTACT FORM</h1>
				</div>
				<p class="indexMessage">${check}</p>
				<form action="newmessage" method="get" class="lemma">
					<div class="lemma-group">
						<textarea class="form-notes" rows="5" name='message' placeholder="Your message..."></textarea>
					</div>
					<div class="button-container">
						<button class="myButton">SEND</button>
					</div>
				</form>
				<div class="button-container">
					<a href="dashboard.jsp"><button class="CADSbutton">DASHBOARD</button></a>
				</div>
			</div>
		</body>

		</html>