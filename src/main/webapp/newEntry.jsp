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
		<h1>New entry</h1>
	</header>
	<div>
		<a href="dashboard.jsp"><button>Dashboard</button></a>
	</div>
	<p>${message}</p>
	<form action="newentry" method="get">
		<div class="lemma-group">
			<label>Lemma</label> <input name='entry' type="text"
				class="form-lemma" id="lemmaForm">
		</div>
		<div class="lemma-group">
			<label>Grammatical category</label> <select class="form-lemma"
				id="lemmaFormGrammCat" name='grammarClass'>
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
			<label>Note</label>
			<textarea class="form-lemma" id="lemmaFormNote" rows="5" name='note'></textarea>
		</div>
		<div>
			<button>Inserisci</button>
		</div>
	</form>
</body>
</html>