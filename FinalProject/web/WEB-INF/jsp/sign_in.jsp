<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 17.07.2019
  Time: 2:25
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
    <a class="navbar-brand" href="index.jsp">Leto</a>
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="#">Участники</a>
        </li>
        <li class="nav-item active">
            <form  action="ProjectServlet" method="post">
                <button  class="btn btn-primary btn-block " type="submit">Регистрация</button>
                <input type="hidden" name="command" value="sign_in">
            </form>
        </li>
    </ul>
</nav>
<div>
    <h3 class="text-center text-white pt-5">Sign in</h3>
    <div class="container">
        <div  class="row justify-content-center align-items-center">
            <div  class="col-md-6">
                <div  class="col-md-12">
                    <form class="form" action="ProjectServlet" method="post">
                        <h3 class="text-center text-info">Login</h3>
                        <div class="form-group">
                            <label for="username" class="text-info">Username:</label><br>
                            <input type="text" name="inputEmail" id="username" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="password" class="text-info">Password:</label><br>
                            <input type="text" name="inputPassword" placeholder="Пароль" required id="password" class="form-control">
                        </div>
                        <div class="form-group">
                            <input type="hidden" name="command" value="login">
                            <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                        </div>
                        </form>
                    <form class="form" action="ProjectServlet" method="post">
                        <div  class="text-right">
                            <button  class="btn btn-info btn-md " type="submit">Регистрация</button>
                        </div>
                        <input type="hidden" name="command" value="registration_page">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<footer class="page-footer font-small bg-dark text-white cyan darken-3  fixed-bottom">
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
        <a href="https://training.by/#/Home">training.by</a>
    </div>
</footer>
</body>
<script src="js/bootstrap.js"></script>
</html>
