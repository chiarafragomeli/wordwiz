<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Results</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/wordwiz.css">
</head>
<body>
	<header>
       <h1>Results</h1>
    </header>
	<ul>
		<c:forEach items="${text}" var="item">
			<li><a href="searchentry">${item.author}, ${item.title}, ${item.fragment}</a></li>	
		</c:forEach>
	</ul>
</body>
</html>