<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Login</title>
            <link rel="stylesheet" href="css/wordwiz.css">
            <meta name="viewport" content="width=device-width">
        </head>

        <body class="indexBody">
            <div class="login-box" align="center">
                <div class="indexHeader">
                    <img src="img/logowithoutbackground.png" width="500">
                </div>
                <div class="motto">Create your own dictionary
                </div>
                <c:if test="${not empty message}">
                    <p class="indexMessage">${message}</p>
                </c:if>
                <form action="login" method="post">
                    <div class="user-box">
                        <input name="user" value="${param.user}" type="text" placeholder="Username">
                    </div>
                    <div class="user-box">
                        <input name="password" type="password" id="inputPassword" placeholder="Password">
                    </div>
                    <button class="myButton">LOGIN</button>
                </form>
                <div class="button-container-home">
                    <a href="index.jsp"><button class="CADSbutton">HOME</button></a>
                </div>
            </div>
        </body>

        </html>