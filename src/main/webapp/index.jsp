<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<title>WordWiz</title>
			<link rel="stylesheet" href="css/wordwiz.css">
			<meta name="viewport" content="width=device-width">
		</head>

		<body class="indexBody">
			<div class="login-box" align="center">
				<div class="indexHeader">
					<img src="img/logowithoutbackground.png" width="500">
				</div>
				<div class="motto">Create your own dictionary</div>
				<c:choose>
					<c:when test="${not empty user}">
						<p class="indexMessage">Hi, ${user.username}!</p>
						<div class="button-container"><a href="dashboard.jsp"><button class="myButton">DASHBOARD</button></a></div>
						<div class="button-container"><a href="signup.jsp"><button class="myButton">SIGN UP</button></a></div>
					</c:when>
					<c:otherwise>
						<div class="button-container"><a href="login.jsp"><button class="myButton">LOGIN</button></a></div>
						<div class="button-container"><a href="signup.jsp"><button class="myButton">SIGN UP</button></a></div>
					</c:otherwise>
				</c:choose>
			</div>
		</body>

		</html>