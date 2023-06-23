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
		<h1>Dashboard</h1>
	</header>
	<c:if test="${not empty message}">
		<p>${message}</p>
	</c:if>
	<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item"><a class="nav-link" href="newEntry.jsp">New
					entry</a></li>
			<li class="nav-item"><a class="nav-link" href="alltext">Corpus</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="userinfo.jsp">Area Personale</a>
			</li>
		</ul>
	</div>
	</nav>
</body>
</html>