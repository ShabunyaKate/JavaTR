<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 07.07.2019
  Time: 13:55
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
<nav class="navbar navbar-expand-sm bg-primary text-white navbar-dark fixed-top">
  <a class="navbar-brand" href="index.jsp"><h4>Leto</h4> </a>
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
<h2 class= "text-info">Leto-один из лучших летних фестивалей в Беларуси</h2>
<hr class="featurette-divider">
<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="img/1с.jpg" alt="2019" width="50">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="img/2с.jpg" alt="2018" width="50">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="img/3c.jpg" alt="2017" width="50">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

<div class="container">
  <hr class="featurette-divider">
  <h2 class="text-info">Leto 2019</h2>
  <p>Фестиваль масштабно вышел на орбиту второго десятилетия и, как обычно, дарит живые выступления знаменитых музыкантов! В прошлом году "Leto" посетило не менее 45 000 человек! Но в этом году мы ждем еще больше гостей, не зря площадь фестиваля увеличивается с каждым годом.

    Огромный заряд положительных эмоций, любимые исполнители, очередной шаг в совершенствовании сервиса (в частности, больше точек на фудкорте!), встречи с друзьями - этот яркий день запомнится надолго. До встречи на "Leto" - продажа билетов уже началась!

  </p>
  <hr class="featurette-divider">
</div>
<footer class="page-footer font-small bg-dark text-white cyan darken-3" >
  <div class="footer-copyright text-center py-3">© 2019 Copyright:
    <label>Katerina Shabunya</label>
  </div>
</footer>
</body>
<script src="js/bootstrap.js"></script>
</html>