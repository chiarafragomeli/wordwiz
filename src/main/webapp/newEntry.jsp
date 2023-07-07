<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<title>New Entry</title>
			<link rel="stylesheet" href="css/wordwiz.css">
		</head>

		<body class="dashboardBody">
			<div class="form-lemma" align="center">
				<div>
					<h1 class="entry-title">NEW ENTRY</h1>
					<p class="indexMessage">${message}</p></div>
				<form action="newentry" method="get">
					<div>
						<input name='entry' type="text" placeholder="Entry">
					</div>
					<div>
						<select id="lemmaFormGrammCat" name='grammarClass'>
							<option value="" disabled selected>Grammatical category</option>
							<option value='2'>Adjective</option>
							<option value='6'>Article</option>
							<option value='4'>Adverb</option>
							<option value='8'>Conjuction</option>
							<option value='9'>Interjection</option>
							<option value='5'>Pronoun</option>
							<option value='7'>Preposition</option>
							<option value='1'>Noun</option>
							<option value='3'>Verb</option>
						</select>
					</div>
					<div>
						<textarea class="form-notes" rows="10" name='note'
							placeholder="Insert a note..."></textarea>
					</div>
					<div>
						<button class="myButton">INSERT</button>
					</div>
				</form>
				<div class="button-container">
					<a href="dashboard.jsp"><button class="CADSbutton">DASHBOARD</button></a>
				</div>
			</div>

		</body>

		</html>