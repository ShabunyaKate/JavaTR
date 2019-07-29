<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 17.07.2019
  Time: 3:30
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-primary text-white navbar-dark  justify-content-center fixed-top">
    <a class="navbar-brand" href="index.jsp">Leto</a>
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="ProjectServlet?link=table_fest">Участники</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="ProjectServlet?link=sign_in">Войти</a>
        </li>
    </ul>
</nav>
<div>
    <hr class="featurette-divider">
    <hr class="featurette-divider">
    <div class="container">
        <div  class="row justify-content-center align-items-center">
            <div  class="col-md-6">
                <div  class="col-md-12">
                    <form class="form" action="ProjectServlet" method="post">
                        <h3 class="text-center text-info">Регистрация</h3>
                        <div class="form-group">
                            <label class="text-info">Введите имя:</label><br>
                            <input type="text" name="name"  placeholder="name" class="form-control" required autofocus>
                        </div>
                        <div class="form-group">
                            <label class="text-info">Введите фамилию:</label><br>
                            <input type="text" name="surname"  placeholder="surname" class="form-control" required autofocus>
                        </div>
                        <div class="form-group">
                            <label class="text-info">Введите дату рождения:</label><br>
                            <input type="date" name="birthday"  placeholder="birthday" class="form-control" required autofocus>
                        </div>
                        <div class="form-group">
                            <label class="text-info">Введите email:</label><br>
                            <input type="email" name="email"  placeholder="email" class="form-control" required autofocus>
                        </div>
                        <div class="form-group">
                            <label class="text-info">Введите номер телефона:</label><br>
                            <input type="text" name="phone"  placeholder="phone" class="form-control" required autofocus>
                        </div>
                        <div class="form-group">
                            <label class="text-info">Введите логин:</label><br>
                            <input type="text" name="login"  placeholder="login" class="form-control" required autofocus>
                        </div>
                        <div class="form-group">
                            <label class="text-info">Введите пароль:</label><br>
                            <input type="password" name="password"  placeholder="password" class="form-control" required autofocus>
                        </div>
                        <div class="form-group">
                            <label class="text-info">Выберете аватар</label>
                        </div>
                        <div>
                            <input type="radio" id="1"  name ="avatar" value="img/avatar/boy.jpg">
                            <label  for="1" class="text-info" >Boy</label>
                            <img src="img/avatar/boy.jpg" class="rounded" alt="Cinque Terre" width="50">
                            <input type="radio" id="2" name="avatar" value="img/avatar/girl.jpg">
                            <label  for="2" class="text-info">Girl</label>
                          <img src="img/avatar/girl.jpg" class="rounded" alt="Cinque Terre" width="50">
                                <input type="radio" id="3" name ="avatar" value="img/avatar/bird.jpg">
                                <label  for="3" class="text-info">Bird</label>
                               <img src="img/avatar/bird.jpg" class="rounded" alt="Cinque Terre" width="50" -->
                                <input type="radio" id="4" name="avatar" value="img/avatar/cat.jpg">
                                <label for="4" class="text-info">Cat</label>
                               <img src="img/avatar/cat.jpg" class="rounded" alt="Cinque Terre" width="50">
                                <input type="radio" id="5" name="avatar"  value="img/avatar/dog.jpg">
                                <label for="5" class="text-info">Dog</label>
                            <img src="img/avatar/dog.jpg" class="rounded" alt="Cinque Terre" width="50" >
                        </div>
                        <div class="form-group">
                            <input type="hidden" name="command"  value="registration">
                            <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer -->
<footer class="page-footer font-small bg-dark text-white cyan darken-3">
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
        <label>Katerina Shabunya</label>
    </div>
</footer>
</body>
<script src="js/bootstrap.js"></script>
</html>

