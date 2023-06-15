<!DOCTYPE html>
<html>

<head>
    <title>WordWiz</title>
    <link rel="stylesheet" href="css/wordwiz.css">
</head>

<body>
    <header>
        <h1>Dashboard</h1>
    </header>
    <c:if test="${not empty message}">
      <p>${message}</p>
  </c:if>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
          <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item">
              <a class="nav-link" href="newEntry.html">New entry</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="corpus.html">Corpus</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="index.html">Logout</a>
              </li>
          </ul>
        </div>
      </nav>
</body>
</html>