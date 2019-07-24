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
<div class="col-md-5">
  <img src="img/vd.jpg" class="rounded" alt="Cinque Terre">
</div>
<!-- Footer -->
<footer class="page-footer font-small bg-dark text-white cyan darken-3">
  <div class="footer-copyright text-center py-3">© 2019 Copyright:
    <a href="https://training.by/#/Home">training.by</a>
  </div>
</footer>
</body>
<script src="js/bootstrap.js"></script>
</html>
