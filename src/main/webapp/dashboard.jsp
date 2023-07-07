<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<title>Dashboard</title>
			<link rel="stylesheet" href="css/wordwiz.css">
		</head>

		<body class="dashboardBody">
			<div class="container-dashboard" align="center">
				<div class="dashboardHeader" align="center">
					<img src="img/dashboardlogo.png" width="500">
				</div>
				<c:if test="${not empty message}">
					<p class="indexMessage" align="center">${message}</p>
				</c:if>
				<div align="center">
					<div><a href="newEntry.jsp"> <button class="myButton">NEW ENTRY</button></a></div>
					<div><a href="allentriesuser"> <button class="myButton">MY GLOSSARY</button class="myButton"></a>
					</div>
					<div><a href="alltext"><button class="myButton">CORPUS</button></a></div>
					<div><a href="userinfo.jsp"><button class="myButton">PERSONAL INFO</button></a></div>
					<div><a href="contactForm.jsp"><button class="myButton">CONTACT FORM</button></a></div>
					<div class="button-container">
						<a href="index.jsp"><button class="CADSbutton">HOME</button></a>
						<a href="logout"><button class="CADSbutton">LOGOUT</button></a>
					</div>
				</div>
			</div>
		</body>

		</html>