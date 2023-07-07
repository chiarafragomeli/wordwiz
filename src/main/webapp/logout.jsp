<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Logout</title>
<link rel="stylesheet" href="css/wordwiz.css">
</head>

<body class="indexBody">
	<div class="login-box">
		<div class="indexHeader">
			<img src="img/logowithoutbackground.png" width="500">
		</div>
		<div class="motto">Create your own dictionary</div>
		<c:if test="${not empty message}">
			<p class="indexMessage">${message}</p>
		</c:if>
		<div class="button-container-home">
		<a href="index.jsp"><button class="CADSbutton">HOME</button></a>
	</div>
	</div>
	
</body>
</html>