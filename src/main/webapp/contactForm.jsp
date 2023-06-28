<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Contact form</title>
<link rel="stylesheet" href="css/wordwiz.css">
</head>

<body>
	<header>
		<h1 class="title">Contatta l'amministratore</h1>
	</header>
	<div>
		<a href="dashboard.jsp"><button>Dashboard</button></a>
	</div>
	<p>${check}</p>
	<form action="newmessage" method="get" class="lemma">
		<div class="lemma-group">
			<textarea class="form-notes" id="lemmaFormNote" rows="5" name='message' placeholder="Inserisci un messaggio..."></textarea>
		</div>
		<div>
			<button>Invia</button>
		</div>
	</form>
</body>
</html>