<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Dashboard</title>
<link rel="stylesheet" href="css/wordwiz.css">
</head>

<body>
	<div class="container">
		<h1 id="dash">Dashboard</h1>
		<c:if test="${not empty message}">
			<p>${message}</p>
		</c:if>
		<div align="center">
			<a class="myButton" href="newEntry.jsp">Inserisci una nuova voce</a>

			<a class="myButton" href="allentriesuser">Il mio glossario</a>
			<a class="myButton" href="alltext">Corpus</a>
			<a class="myButton" href="userinfo.jsp">Area personale</a>
			<a class="myButton" href="contactForm.jsp">Contatta l'amministratore</a>

		</div>

		<div class="button-container">
			<a href="index.jsp" class="CADSbutton">Home</a>
			<a href="logout" class="CADSbutton">Esci</a>
		</div>
	</div>
</body>
</html>


