<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/wordwiz.css">
</head>

<body>
	<div class="container-fluid">
		<header>
			<h1>Logout</h1>
		</header>
		<c:if test="${not empty message}">
			<p>${message}</p>
		</c:if>
		<div>
			<a href="index.jsp"><button>Home</button></a>
		</div>
</body>
</html>