<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 17.07.2019
  Time: 3:30
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
                <input type="hidden" name="command" value="change_Lang">
                <input type="hidden" name="link" value="registration">
                <input type="radio" name="change" value="ru_RU" onchange="this.form.submit()">RU
                <input type="radio" name="change" value="en_US" onchange="this.form.submit()"> EN
                <input type="radio" name="change" value="de_DE" onchange="this.form.submit()"/>DE<br/><br/>
            </form>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="ProjectServlet?link=sign_in"><fmt:message key="nav.client.signin"/></a>
        </li>
    </ul>
</nav>
<div>
    <hr class="featurette-divider">
    <hr class="featurette-divider">
    <hr class="featurette-divider">
    <div class="container">
        <div class="row justify-content-center align-items-center">
            <div class="col-md-6">
                <div class="col-md-12">
                    <form class="form" action="ProjectServlet" method="post">
                        <h3 class="text-center text-info"><fmt:message key="registration"/></h3>
                        <div class="form-group">
                            <label class="text-info"><fmt:message key="r.login"/></label><br>
                            <input type="text" name="login" pattern="^[а-яА-ЯёЁa-zA-Z0-9]+$" minlength="3" maxlength="15" class="form-control ntSaveForms" required autofocus>
                        </div>
                        <c:if test="${exception !=null}">
                            <h7 class="text-danger"><fmt:message key="exception.unique_login"/></h7>
                        </c:if>
                        <div class="form-group">
                            <label class="text-info"><fmt:message key="r.password"/></label><br>
                            <input type="password" pattern="^[a-zA-Z0-9]{8,25}$" name="password" minlength="8" maxlength="25" class="form-control ntSaveForms" required autofocus>
                        </div>
                        <div class="form-group">
                            <label class="text-info"><fmt:message key="r.name"/></label><br>
                            <input type="text" pattern="^[а-яА-ЯёЁa-zA-Z]+$" maxlength="15"  name="name" class="form-control ntSaveForms " required autofocus>
                        </div>
                        <div class="form-group">
                            <label class="text-info"><fmt:message key="r.surname"/></label><br>
                            <input type="text" pattern="^[а-яА-ЯёЁa-zA-Z]+$" name="surname" maxlength="30" class="form-control ntSaveForms" required autofocus>
                        </div>
                        <div class="form-group">
                            <label class="text-info"><fmt:message key="r.date"/></label><br>
                            <input type="date" name="birthday" min="1920-01-01" max="2020-01-01" class="form-control ntSaveForms" required autofocus>
                        </div>

                        <div class="form-group">
                            <label class="text-info"><fmt:message key="r.email"/></label><br>
                            <input type="email" name="email" class="form-control ntSaveForms" required autofocus>
                        </div>
                        <div class="form-group">
                            <label class="text-info"><fmt:message key="r.phone"/></label><br>
                            <input type="text" name="phone" min="3" maxlength="20" pattern="^\+[1-9]{1}[0-9]{3,14}$" class="form-control ntSaveForms" required autofocus>
                        </div>
                        <div class="form-group">
                            <label class="text-info"><fmt:message key="r.avatar"/></label>
                        </div>
                        <div>
                            <input type="radio" id="1" name="avatar" value="img/avatar/boy.jpg">
                            <%--<label  for="1" class="text-info" >Boy</label>--%>
                            <img src="img/avatar/boy.jpg" class="rounded" alt="Cinque Terre" width="50">
                            <input type="radio" id="2" name="avatar" value="img/avatar/girl.jpg">
                            <%--<label  for="2" class="text-info">Girl</label>--%>
                            <img src="img/avatar/girl.jpg" class="rounded" alt="Cinque Terre" width="50">
                            <input type="radio" id="3" name="avatar" value="img/avatar/bird.jpg">
                            <%--<label  for="3" class="text-info">Bird</label>--%>
                            <img src="img/avatar/bird.jpg" class="rounded" alt="Cinque Terre" width="50" -->
                            <input type="radio" id="4" name="avatar" value="img/avatar/cat.jpg">
                            <%--<label for="4" class="text-info">Cat</label>--%>
                            <img src="img/avatar/cat.jpg" class="rounded" alt="Cinque Terre" width="50">
                            <input type="radio" id="5" name="avatar" value="img/avatar/dog.jpg">
                            <%--<label for="5" class="text-info">Dog</label>--%>
                            <img src="img/avatar/dog.jpg" class="rounded" alt="Cinque Terre" width="50">
                        </div>
                        <div class="form-group">
                            <c:if test="${repeat !=null}"><h7 class="text-info">${repeat}</h7></c:if>
                            <input type="hidden" name="command" value="registration">
                            <input type="submit" name="submit" class="btn btn-info btn-md" value=<fmt:message key="registration"/>>
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
<script type='text/javascript' src='js/ntsaveforms.js'></script>
<script src="js/bootstrap.js"></script>
</html>

