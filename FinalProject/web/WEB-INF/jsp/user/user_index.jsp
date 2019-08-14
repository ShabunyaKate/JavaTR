<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 24.07.2019
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Leto Fest</title>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="leto.png" type="image/png">
    <link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-sm bg-primary text-white navbar-dark  justify-content-center fixed-top">
    <a class="navbar-brand" href="ProjectServlet?link=user_index">Leto</a><!--поменять jsp-->
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="ProjectServlet?link=buy_ticket">Купить билет</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="ProjectServlet?link=user_ticket">Moи билеты</a>
        </li>
    </ul>
    <ul class="navbar-nav ml-auto">
        <li class="nav-item">
            <img src=${user.avatar} class="rounded" alt="Cinque Terre" width="50">
        </li>
        <li  class="nav-item"><p>${user.login}</p></li>
        <li class="nav-item active">
            <form  action="ProjectServlet" method="post">
                <button  class="btn btn-info btn-block " type="submit">Sign Out</button>
                <input type="hidden" name="command" value="sign_out">
            </form>
        </li>
    </ul>
</nav>
<hr class="featurette-divider">
<hr class="featurette-divider">
<hr class="featurette-divider">
<div class="container">
    <hr class="featurette-divider">
    <h2 class="text-info">Дорогой участник фестиваля Leto, <h2 class="text-black-50">${user.login}</h2> </h2>
    <h4 class="text-success text-center">
        В данном профиле вы можете:
        <hr class="featurette-divider">
        <h4 class="text-success text-info"> 1)Забронировать билет</h4>
        <hr class="featurette-divider">
        <h4 class="text-success text-info">2)Просмотреть все забронированные билеты и их общую стоймость</h4>
    </h4>
    <hr class="featurette-divider">
</div>
<!-- Footer -->
<footer class="page-footer font-small bg-dark text-white cyan darken-3 fixed-bottom" >
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
        <label>Katerina Shabunya</label>
    </div>
</footer>
</body>
<script src="js/bootstrap.js"></script>
</html>
