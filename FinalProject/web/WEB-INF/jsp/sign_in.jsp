<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 17.07.2019
  Time: 2:25
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
            <form action="ProjectServlet" method="POST">
                <input type="hidden" name="command"  value="change_Lang">
                <input type="hidden" name="link"  value="sign_in">
                <input type="radio" name="change" id="1" value="ru_RU" onchange="this.form.submit()" >RU
                <input type="radio" name="change" id="2" value="en_US" onchange="this.form.submit()"> EN
                <input type="radio" name="change" id="3" value="de_DE" onchange="this.form.submit()" />DE<br/><br/>
            </form>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="ProjectServlet?link=sign_in"><fmt:message key="nav.client.signin"/></a>
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
                        <h3 class="text-center text-info"><fmt:message key="nav.client.signin"/></h3>
                        <div class="form-group">
                            <label for="username" class="text-info"><fmt:message key="login"/></label><br>
                            <input type="text" name="login" id="username" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="password" class="text-info"><fmt:message key="password"/></label><br>
                            <input type="password" name="password"  required id="password" class="form-control">
                        </div>
                        <c:if test="${exception !=null}"><h7 class="text-danger">${exception}</h7></c:if>
                        <div class="form-group">
                            <input type="hidden" name="command" value="sign_in">
                            <input type="submit" name="submit" class="btn btn-info btn-md" value=<fmt:message key="nav.client.signin"/>>
                        </div>
                        </form>
                    <div id="register-link" class="text-right">
                        <a href="ProjectServlet?link=registration" class="text-info"><fmt:message key="registration"/></a>
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
