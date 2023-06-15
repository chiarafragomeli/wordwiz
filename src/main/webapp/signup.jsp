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
            <div class="container-fluid">
                <header>
                    <h1>Sign up</h1>
                </header>
                <div>
                    <a href="index.jsp"><button>Home</button></a>
                </div>
                <c:if test="${not empty message}">
                    <p>${message}</p>
                </c:if>
                <form action="signup" method="post">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                        </div>
                        <input name="user" value="${param.user}" type="text" class="form-control" placeholder="Username" aria-label="Username"
                            aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                        </div>
                        <input name="email" value="${param.email}" type="text" class="form-control" placeholder="Email" aria-label="Email"
                            aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                        </div>
                        <input name ="password" type="password" class="form-control" id="inputPassword" placeholder="Password">
                    </div>
                    <div><button>Signup</button></div>
                </form>
            </div>
        </body>

        </html>