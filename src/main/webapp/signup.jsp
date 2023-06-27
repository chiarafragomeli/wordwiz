<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Sign up</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                crossorigin="anonymous">
            <link rel="stylesheet" href="css/wordwiz.css">
        </head>

        <body>
            <div class="login-box">
                <header>
                    <h2>Sign up</h2>
                </header>
                <div class="frame">
                    <a href="index.jsp"><button class="custom-btn btn-5">Home</button></a>
                </div>
                <c:if test="${not empty message}">
                    <p>${message}</p>
                </c:if>
                <form action="signup" method="post">
                    <div class="user-box">
                        <input name="user" value="${param.user}" type="text" placeholder="Username">
                    </div>
                    <div class= "user-box">
                        <input name="email" value="${param.email}" type="text" placeholder="Email">
                    </div>
                    <div class="user-box">
                        <input name ="password" type="password" id="inputPassword" placeholder="Password">
                    </div>
                    <button>Signup</button>
                </form>
            </div>
        </body>

        </html>