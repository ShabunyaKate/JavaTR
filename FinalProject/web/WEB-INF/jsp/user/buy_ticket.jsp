<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 30.07.2019
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Leto Fest</title>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="leto.png" type="image/png">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/1.css" rel="stylesheet">
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
<form class="form" action="ProjectServlet" method="post">
    <h3 class="text-center text-info" >Забронировать билет</h3>
        <hr class="featurette-divider">
        <h4 class="text-info text-center">Выберете тип билета</h4>
    <div class="row">
        <div class="col"></div>
        <div class="col">
            <select class="custom-select mr-sm-2" name="book_id_ticket">
                <c:forEach items="${tickets}" var="item">
                    <option value="${item.id}">День:${item.day.date} Тип:${item.type} </option>
                    <hr class="featurette-divider">
                </c:forEach>
            </select>
        </div>
        <div class="col"></div>
    </div>
    <hr class="featurette-divider">
    <div class="row">
        <div class="col"></div>
        <div class="col">
            <h4 class="text-info text-center">Введите нужное количество билетов</h4>
            <input type="number" name="count" class="form-control" minlength="1" maxlength="2" min="1" max="10" required>
        </div>
        <div class="col"></div>
    </div>
    <div class="form-group">
        <input type="hidden" name="command"  value="book_ticket">
        <h1 class="text-center"> <input type="submit" name="submit" class="btn btn-info btn-md" value="Забронировать"></h1>
    </div>
</form>
<!-- Footer -->
<footer class="page-footer font-small bg-dark text-white cyan darken-3 fixed-bottom" >
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
        <label>Katerina Shabunya</label>
    </div>
</footer>
</body>
<script src="js/bootstrap.js"></script>
</html>


