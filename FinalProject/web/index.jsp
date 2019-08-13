<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 07.07.2019
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:if test="${lang ==null}"><fmt:setLocale value="ru_RU" scope="session"/></c:if>
<c:if test="${lang !=null}"><fmt:setLocale value="${lang}" scope="session"/></c:if>
<fmt:setBundle basename="language"/>
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
    <a class="nav-link" href="ProjectServlet?link=table_fest"> <fmt:message key="nav.client.fest"/></a>
  </li>
  </ul>
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
      <form action="ProjectServlet" method="POST">
        <input type="hidden" name="command"  value="change_Lang">
        <input type="hidden" name="link"  value="index">
        <input type="radio" name="change" id="1" value="ru_RU" onchange="this.form.submit()" >RU
        <input type="radio" name="change" id="2" value="en_US" onchange="this.form.submit()"> EN
        <input type="radio" name="change" id="3" value="de_DE" onchange="this.form.submit()" />DE<br/><br/>
      </form>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="ProjectServlet?link=sign_in"> <fmt:message key="nav.client.signin"/></a>
      </li>
    </ul>
</nav>
<hr class="featurette-divider">
<hr class="featurette-divider">
<hr class="featurette-divider">
<h2 class= "text-info">
  <fmt:message key="index.greating"/></h2>
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
  <p>
    <fmt:message key="index.description"/>
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