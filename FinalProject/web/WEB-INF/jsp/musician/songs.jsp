<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 18.07.2019
  Time: 2:55
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
            <a class="nav-link" href="ProjectServlet?link=songs">Удаление и добавление песен</a>
        </li>
        <li class="nav-item">
            <a class="nav-link disabled"  href="ProjectServlet?link=musician_photo">Изменить фото</a>
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
<div class="form-group">
<h3 class="text-center text-success" >Песни</h3>
<hr class="featurette-divider">
<c:forEach items="${musician.songs}" var="item">
    <h6 class="text-center ">${item.song}</h6>
    <hr class="featurette-divider">
</c:forEach>
</div>
<form class="form" action="ProjectServlet" method="post">
<h3 class="text-center text-success" >Добавление песни</h3>
<div class="form-group">
    <div class="row">
        <div class="col"></div>
        <div class="col">
    <input type="text" name="add_new_song" class="form-control" required>
        </div>
        <div class="col"></div>
    </div>
    <input type="hidden" name="command"  value="add_song">
    <h1 class="text-center"> <input type="submit" name="submit" class="btn btn-info btn-md" value="Добавить"></h1>
</div>
</form>

<form class="form" action="ProjectServlet" method="post">
<h3 class="text-center text-success" >Удаление песни</h3>
    <div class="row">
        <div class="col"></div>
        <div class="col">
<select class="custom-select mr-sm-2" name="delete_id_song">
    <c:forEach items="${musician.songs}" var="item">
        <option value="${item.id}">${item.song}</option>
        <hr class="featurette-divider">
    </c:forEach>
</select>
        </div>
        <div class="col"></div>
    </div>
    <input type="hidden" name="command"  value="delete_song">
  <h1 class="text-center"> <input type="submit" name="submit" class="btn btn-info btn-md text-center" value="Удалить"></h1>
</form>

<form method="post" action="DownloadServlet" enctype="multipart/form-data">
    Choose a file: <input type="file" name="multiPartServlet" />
    <input type="submit" value="Upload" />
</form>

<!-- Footer -->
<footer class="page-footer font-small bg-dark text-white cyan darken-3" >
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
        <label>Katerina Shabunya</label>
    </div>
</footer>
</body>
<script src="js/bootstrap.js"></script>
</html>