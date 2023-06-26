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
		<h1 class="title">Inserimento lemma</h1>
	</header>
	<div>
		<a href="dashboard.jsp"><button>Dashboard</button></a>
	</div>
	<p>${message}</p>
	<form action="newentry" method="get" class="lemma">
		<div class="lemma-group1">
			<input name='entry' type="text"
				class="form-lemma" id="lemmaForm" placeholder="Inserisci lemma">
		</div>
		<div class="lemma-group2">
			<select class="form-lemma"
				id="lemmaFormGrammCat" name='grammarClass'>
				<option value="" disabled selected>Grammatical category</option>
				<option value='2'>Aggettivo</option>
				<option value='6'>Articolo</option>
				<option value='4'>Avverbio</option>
				<option value='8'>Congiunzione</option>
				<option value='9'>Interiezione</option>
				<option value='5'>Pronome</option>
				<option value='7'>Preposizione</option>
				<option value='1'>Nome</option>
				<option value='3'>Verbo</option>
			</select>
		</div>
		<div class="lemma-group">
			<textarea class="form-notes" id="lemmaFormNote" rows="5" name='note' placeholder="Inserisci note..."></textarea>
		</div>
		<div>
			<button>Inserisci</button>
		</div>
	</form>
</body>
</html>