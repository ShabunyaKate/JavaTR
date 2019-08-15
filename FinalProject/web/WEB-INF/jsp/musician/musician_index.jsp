<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 25.07.2019
  Time: 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Leto Fest</title>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="leto.png" type="image/png">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/1.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-success text-white navbar-dark  justify-content-center fixed-top">
    <a class="navbar-brand" href="ProjectServlet?link=musician_index"><h4 class="text-warning">Leto</h4></a>
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="ProjectServlet?link=songs">Управление песнями и фотографиями</a>
        </li>
    </ul>
    <ul class="navbar-nav ml-auto">
        <li  class="nav-item"><p>${musician.user.login}</p></li>
        <li class="nav-item active">
            <form  action="ProjectServlet" method="post">
                <button  class="btn btn-success btn-block " type="submit">Sign Out</button>
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
    <h2 class="text-success">Дорогой участник фестиваля Leto, <h2 class="text-warning">${musician.user.login}</h2> </h2>
    <h4 class="text-success text-center">
        В данном профиле вы можете:
        <hr class="featurette-divider">
        <h4 class="text-success text-center"> 1) добавить или удалить ваши песни в плейлисте.</h4>
        <hr class="featurette-divider">
        <h4 class="text-success text-center">2) загрузить фотографию, которая будет отображаться на главной странице сайта</h4>
    </h4>
    <hr class="featurette-divider">
</div>
<!-- Footer -->
<footer class="page-footer font-small bg-dark text-white cyan darken-3 fixed-bottom">
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
        <label>Katerina Shabunya</label>
    </div>
</footer>
</body>
<script src="js/bootstrap.js"></script>
</html>


