<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 18.07.2019
  Time: 0:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <a class="navbar-brand" href="index.jsp"><h4>Leto</h4></a>
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="ProjectServlet?link=table_fest"><fmt:message key="nav.client.fest"/></a>
        </li>
    </ul>
    <ul class="nav navbar-nav">
    </ul>
    <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
            <a class="nav-link" href="ProjectServlet?link=sign_in"><fmt:message key="nav.client.signin"/></a>
        </li>
    </ul>
</nav>
<hr class="featurette-divider">
<hr class="featurette-divider">
<hr class="featurette-divider">
<h2 class="text-info"><fmt:message key="fest.label"/></h2>
<div class="container-fluid">
    <c:forEach items="${map}" var="entry">
        <h1><fmt:formatDate value="${entry.key.date}"  /></h1>
        <div class="row">
        <c:forEach items="${entry.value}" var="item">
            <hr class="featurette-divider">
            <div class="col-sm-4">
                <c:if test="${item.img==null}">
                <img src="img/avatar/bird.jpg" alt="Vogue" style="width:50%;">
                </c:if>
                <c:if test="${item.img!=null}">
                <img src="data:image/jpeg;base64, ${item.img}"/>
                </c:if>
            </div>
            <div class="col-sm-8">
                <div id="accordion">
                    <div class="card">
                        <div class="card-header bg-info" id="headingOne">
                            <h5 class="mb-0">
                                <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    <p3 class="text-white">${item.user.login}</p3>
                                </button>
                            </h5>
                        </div>
                        <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                            <div class="card-body">
                                <c:forEach items="${item.songs}" var="song">
                                    <p3>${song.song}</p3>
                                    <hr class="featurette-divider">
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                  </div>
            </div>
            <hr class="featurette-divider">
        </c:forEach><br>
        </div>
        <hr class="featurette-divider">
    </c:forEach>
</div>
<footer class="page-footer font-small bg-dark text-white cyan darken-3" >
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
        <label>Katerina Shabunya</label>
    </div>
</footer>
</body>
<script src="js/bootstrap.js"></script>
</html>
