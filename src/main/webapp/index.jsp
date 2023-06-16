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
		<h1>WordWiz</h1>
	</header>
	<c:choose>
		<c:when test="${not empty user}">
			<p>Ciao ${user.username}</p>
			<a href="dashboard.jsp"><button>Dashboard</button></a>
			<a href="signup.jsp"><button>Sign up</button></a>
		</c:when>
		<c:otherwise>
			<a href="login.jsp"><button>Login</button></a>
			<a href="signup.jsp"><button>Sign up</button></a>
		</c:otherwise>
	</c:choose>
</body>
</html>