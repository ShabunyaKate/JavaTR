<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 30.07.2019
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Leto Fest</title>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="leto.png" type="image/png">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/ticket.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-sm bg-primary text-white navbar-dark  justify-content-center fixed-top">
    <a class="navbar-brand" href="ProjectServlet?link=user_index">Leto</a><!--поменять jsp-->
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="ProjectServlet?link=buy_ticket">Купить билет</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="ProjectServlet?link=user_ticket">Moи билеты</a>
        </li>
        <li class="nav-item active">
            <form  action="ProjectServlet" method="post">
                <button  class="btn btn-primary btn-block " type="submit">Sign Out</button>
                <input type="hidden" name="command" value="sign_out">
            </form>
        </li>
    </ul>
</nav>
<hr class="featurette-divider">
<hr class="featurette-divider">
<hr class="featurette-divider">
<section class="container">
    <h1>Билеты</h1>
    <div class="row">
<c:set var="total" value="${0}"/>
<c:forEach items="${usages}" var="item">
        <article class="card fl-left">
            <section class="date">
                <time datetime="23th feb">
                    <span>${user.id}</span>
                </time>
            </section>
            <section class="card-cont">
                <h3>Leto Fest</h3>
                <div class="even-date">
                    <i class="fa fa-calendar"></i>
                    <time>
                        <span>Дата:${item.ticket.day.date}</span>
                       <span>Тип: ${item.ticket.type}</span>
                    </time>
                </div>
                <div class="even-info">
                    <i class="fa fa-map-marker"></i>
                    <p>
                        Цена: $${item.ticket.price} за 1 билет
                    </p>
                </div>
                <a>
                <form class="form" action="ProjectServlet" method="post">
                    <input type="hidden" name="command"  value="delete_usage">
                    <input type="hidden" name="usage_id"  value="${item.id}">
                    <input type="submit" name="submit" class="btn btn-info btn-md" value="Unbook">
                </form>
                </a>
            </section>
        </article>
        <article class="fl-left">
            <h1 class="text-center text-success">* ${item.count}</h1>
        </article>
    <c:set var="total" value="${total + item.ticket.price * item.count}" />
</c:forEach>
    </div>
</section>
<h2 class="text-center text-success">Общая стоймость</h2>
<h3 class="text-center text-info">$${total}</h3>
<!-- Footer -->
<footer class="page-footer font-small bg-dark text-white cyan darken-3 " >
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
        <label>Katerina Shabunya</label>
    </div>
</footer>
</body>
<script src="js/bootstrap.js"></script>
</html>

