<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 17.07.2019
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
</head>
<body>
<nav class="navbar navbar-expand-sm bg-primary text-white navbar-dark fixed-top">
    <a class="navbar-brand" href="index.jsp"><h4>Leto</h4></a>
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="ProjectServlet?link=table_fest">Участники</a>
        </li>
    </ul>
    <ul class="nav navbar-nav">
    </ul>
    <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
            <a class="nav-link" href="ProjectServlet?link=sign_in">Войти</a>
        </li>
    </ul>
</nav>
<hr class="featurette-divider">
<hr class="featurette-divider">
<hr class="featurette-divider">
<div>
    <div class="container">
        <div  class="row justify-content-center align-items-center">
            <div  class="col-md-6">
                <div  class="col-md-12">
                    <form class="form" action="ProjectServlet" method="post">
                        <h3 class="text-center text-info">Войти</h3>
                        <div class="form-group">
                            <label for="username" class="text-info">Логин</label><br>
                            <input type="text" name="login" id="username" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="password" class="text-info">Пароль</label><br>
                            <input type="text" name="password"  required id="password" class="form-control">
                        </div>
                        <c:if test="${exception !=null}"><h7 class="text-danger">${exception}</h7></c:if>
                        <div class="form-group">
                            <input type="hidden" name="command" value="sign_in">
                            <input type="submit" name="submit" class="btn btn-info btn-md" value="Войти">
                        </div>
                        </form>
                    <div id="register-link" class="text-right">
                        <a href="ProjectServlet?link=registration" class="text-info">Зарегистрироваться</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
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
