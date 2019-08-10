<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 18.07.2019
  Time: 4:21
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
<h3 class="text-center text-warning" >Таблица пользователей</h3>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>Логин</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Дата рождения</th>
            <th>email</th>
            <th>Телефон</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.login}</td>
                <td>${user.userInfo.name}</td>
                <td>${user.userInfo.surname}</td>
                <td>${user.userInfo.birthdate}</td>
                <td>${user.userInfo.email}</td>
                <td>${user.userInfo.phone}</td>
                <td>
                <form class="form" action="ProjectServlet" method="post">
                <div class="form-group">
                    <input type="hidden" name="command"  value="delete_user">
                    <input type="hidden" name="user_id"  value=${user.id}>
                    <c:if test="${exception !=null}">
                    <c:if test="${excep_id ==user.id}">
                        <h7 class="text-danger">${exception}</h7>
                    </c:if>
                    </c:if>
                    <input type="submit" name="submit" class="btn btn-info btn-md" value="Удалить">
                </div>
                </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<footer class="page-footer font-small bg-dark text-white cyan darken-3" >
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
        <label>Katerina Shabunya</label>
    </div>
</footer>
</body>
<script src="js/bootstrap.js"></script>
</html>
