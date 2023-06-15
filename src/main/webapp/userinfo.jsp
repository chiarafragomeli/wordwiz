<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>User Info</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/wordwiz.css">
</head>

<body>
	<div>
		<a href="dashboard.jsp"><button>Dashboard</button></a>
	</div>
	<header>
		<h1>Area Personale</h1>
	</header>
	<c:if test="${not empty message}">
        	<p>${message}</p>
        </c:if>
	<ul>
		<li>Username: ${user.username}</li>
		<li>Email: ${user.email}</li>
	</ul>
<form action="userinfo" method="get">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                </div>
                <input name="newEmail" type="text" class="form-control" placeholder="Nuova email">
            </div>
            <div><button>Modifica l'email</button></div>
        </form>
</body>
</html>