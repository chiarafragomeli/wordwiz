<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
		<h1>Risultati</h1>
	</header>
	<div>
		<a href="dashboard.jsp"><button>Dashboard</button></a>
	</div>
	<div>
		<a href="alltext"><button>Corpus</button></a>
	</div>
	<div class="container">
  <table class="table table-fixed">
    <thead>
      <tr>
        <th class="col-xs-3">Autrice</th>
        <th class="col-xs-3">Titolo</th>
        <th class="col-xs-6">Testo</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${text}" var="item">
      <tr>
        <td class="col-xs-3">${item.author}</td>
        <td class="col-xs-3">${item.title}</td>
        <td class="col-xs-6">${item.fragment}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>







