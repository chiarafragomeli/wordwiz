<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>

    <head>
      <title>Results</title>
      <link rel="stylesheet" href="css/wordwiz.css">
    </head>

    <body class="dashboardBody">
      <div class="form-lemma">
        <div>
          <h1 class="entry-title">RESULTS</h1>
        </div>
        <div class="container">
          <table class="table table-fixed">
            <thead>
              <tr>
                <th scope="col">AUTHOR</th>
                <th scope="col">TITLE</th>
                <th scope="col">CONTEXT</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${text}" var="item">
                <tr>
                  <td scope="row">${item.author}</td>
                  <td scope="row">${item.title}</td>
                  <td scope="row">${item.fragment}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
          <div class="button-container">
            <a href="dashboard.jsp"><button class="CADSbutton">Dashboard</button></a>
            <a href="alltext"><button class="CADSbutton">Corpus</button></a>
          </div>
        </div>
      </div>
    </body>

    </html>