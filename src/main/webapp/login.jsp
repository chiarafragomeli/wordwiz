<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/wordwiz.css">
    <style>
        @import url('https://fonts.cdnfonts.com/css/futura-std-4?styles=52567,52574,52575,52570,52576');
    </style>
    <link href="https://fonts.cdnfonts.com/css/tt-rounds-neue-trial" rel="stylesheet">
</head>

<body>
    <div class="container-fluid">
        <header>
            <h1>Login</h1>
        </header>
        <div>
            <a href="index.html"><button>Home</button></a>
        </div>
        <c:if test="${not empty message}">
        	<p>${message}</p>
        </c:if>
        <form action="login" method="post">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                </div>
                <input name="user" value="${param.user}" type="text" class="form-control" placeholder="Username" aria-label="Username"
                    aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                </div>
                <input name="password" type="password" class="form-control" id="inputPassword" placeholder="Password">
            </div>
            <div><button>Login</button></div>
        </form>
    </div>
</body>
</html>