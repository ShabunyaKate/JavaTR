<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 29.07.2019
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<nav class="navbar navbar-expand-sm bg-info text-white navbar-dark  justify-content-center fixed-top">
    <a class="navbar-brand" href="ProjectServlet?link=admin_index">Leto</a>
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="ProjectServlet?link=admin_users">Управление пользователями</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="ProjectServlet?link=admin_musician">Управление музыкантами</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="ProjectServlet?link=admin_fest">Управление фестивалем(дни, цены)</a>
        </li>
    </ul>
    <ul class="navbar-nav ml-auto">
        <li class="nav-item"><p>${user.login}</p></li>
        <li class="nav-item active">
            <form action="ProjectServlet" method="post">
                <button class="btn btn-info btn-block " type="submit">Sign Out</button>
                <input type="hidden" name="command" value="sign_out">
            </form>
        </li>
    </ul>
</nav>
<hr class="featurette-divider">
<hr class="featurette-divider">
<hr class="featurette-divider">
<form class="form" action="ProjectServlet" method="post">
    <div class="form-group">
        <h3 class="text-warning">Добавить день фестиваля</h3>
        <div class="row">
            <div class="col"></div>
            <div class="col">
        <input type="date" name="day" placeholder="date" min="1920-01-01" max="2020-01-01" class="form-control" required autofocus>
            </div>
            <div class="col"></div>
        </div>
        <div class="container">
            <table class="table">
                <thead>
                <tr class="text-center">
                    <th>Цена VIP билет</th>
                    <th>Цена FAN_ZONE билет</th>
                    <th>Цена DANCE_FLOOR билет</th>
                </tr>
                </thead>
                <tbody>
                <tr class="text-center">
                    <td><input type="number" name="VIP" step=".01" minlength="1" maxlength="5" min="1" max="99999" required autofocus></td>
                    <td><input type="number" name="FAN_ZONE" step=".01" minlength="1" maxlength="5" min="1" max="99999" required autofocus></td>
                    <td><input type="number" name="DANCE_FLOOR" step=".01" minlength="1" maxlength="5" min="1" max="99999" required autofocus></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="hidden" name="command" value="add_day">
                        <h1 class="text-center"><input type="submit" name="submit" class="btn btn-info btn-md" value="Добавить"></h1>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</form>

<hr class="featurette-divider">
<form class="form" action="ProjectServlet" method="post">
    <div class="form-group">
        <h3 class="text-warning">Изменение цены</h3>
        <div class="row">
            <div class="col"></div>
            <div class="col">
                <select class="custom-select mr-sm-2" name="day_id">
                    <c:forEach items="${days}" var="day">
                        <option value="${day.id}">${day.date}</option>
                        <hr class="featurette-divider">
                    </c:forEach>
                </select>
            </div>
            <div class="col"></div>
        </div>
        <div class="container">
            <table class="table">
                <thead>
                <tr class="text-center">
                    <th >Цена VIP билет</th>
                    <th>Цена FAN_ZONE билет</th>
                    <th>Цена DANCE_FLOOR билет</th>
                </tr>
                </thead>
                <tbody>
                <tr class="text-center">
                    <td><input type="number" name="VIP" step=".01" minlength="1" maxlength="5" min="1" max="99999" required autofocus></td>
                    <td><input type="number" name="FAN_ZONE" step=".01" minlength="1" maxlength="5" min="1" max="99999" required autofocus></td>
                    <td><input type="number" name="DANCE_FLOOR" step=".01" minlength="1" maxlength="5" min="1" max="99999" required autofocus></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="hidden" name="command" value="update_price">
                        <h1 class="text-center">  <input type="submit" name="submit" class="btn btn-info btn-md" value="Изменить"></h1></td>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </div>

    </div>
</form>
<hr class="featurette-divider">
<footer class="page-footer  bg-dark text-white cyan darken-3">
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
        <label>Katerina Shabunya</label>
    </div>
</footer>
</body>
<script src="js/bootstrap.js"></script>
</html>
