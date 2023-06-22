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
		<h1>Corpus</h1>
	</header>
	<div>
		<a href="dashboard.jsp"><button>Dashboard</button></a>
	</div>
	
	 <form action="searchentry" method="get">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                </div>
                <input name="entry" type="text" class="form-control" placeholder="Search">
            </div>
            <div><button>Search</button></div>
      </form>
	
	<ul>
		<c:forEach items="${text}" var="item">
			<li><a href="onetext?id=${item.id}">${item.author}, ${item.title}</a></li>	
		</c:forEach>
	</ul>
</body>
</html>