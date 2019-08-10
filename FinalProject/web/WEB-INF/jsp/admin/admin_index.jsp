<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 25.07.2019
  Time: 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Leto Fest</title>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="leto.png" type="image/png">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/1.css" rel="stylesheet">0
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
    <h2 class="text-info">Admin Page</h2>
    <h4 class="text-warning text-center">
        Admin, you can
        <h4 class="text-info text-center"> 1)добавить и удалить участников фестиваля </h4>
        <h4 class="text-info text-center">2)удалить пользователя(если он не купил билет)</h4>
        <h4 class="text-info text-center">3)добавить дни и определить цены к ним</h4>
        <h4 class="text-info text-center">4)изменить цены</h4>
    </h4>
    <hr class="featurette-divider">
</div>
<footer class="page-footer font-small bg-dark text-white cyan darken-3 fixed-bottom" >
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
        <label>Katerina Shabunya</label>
    </div>
</footer>
</body>
<script src="js/bootstrap.js"></script>
</html>