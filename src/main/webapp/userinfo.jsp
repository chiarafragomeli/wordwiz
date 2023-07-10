<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<title>Personal Info</title>
			<link rel="stylesheet" href="css/wordwiz.css">
		</head>

		<body class="dashboardBody">
			<div class="form-lemma">
				<div class="entry-title">
					<h1> PERSONAL INFO</h1>
				</div>
				<div>
					<c:if test="${not empty message}">
						<p class="indexMessage">${message}</p>
					</c:if>
				</div>
				<div>
					<p class="indexMessage" name="info"><strong>Username</strong>: ${user.username}</p>
					<p class="indexMessage" name="info"><strong>Email</strong>: ${user.email}</p>
					<form action="userinfo" method="get">
						<div align="center">
							<input name="newEmail" type="text" class="form-control" placeholder="New email">
						</div>
				</div>
				<div align="center"><button class="myButton">UPDATE EMAIL</button></div>
				</form>
				<div class="button-container">
					<a href="dashboard.jsp"><button class="CADSbutton">DASHBOARD</button></a>
				</div>
			</div>
		</body>

		</html>