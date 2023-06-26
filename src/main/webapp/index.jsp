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
<div class="login-box">
	<header>
		<h2>WordWiz</h2>
	</header>
	<c:choose>
		<c:when test="${not empty user}">
			<p>Ciao ${user.username}</p>
			<a href="dashboard.jsp"><button class="custom-btn btn-5">Dashboard</button></a>
			<a href="signup.jsp"><button class="custom-btn btn-5">Sign up</button></a>
		</c:when>
		<c:otherwise>
			<a href="login.jsp"><button class="custom-btn btn-5">Login</button></a>
			<a href="signup.jsp"><button class="custom-btn btn-5">Sign up</button></a>
		</c:otherwise>
	</c:choose>
</div>
</body>
	<div>
		<img src="img/background.jpg">
    </div>

</html>