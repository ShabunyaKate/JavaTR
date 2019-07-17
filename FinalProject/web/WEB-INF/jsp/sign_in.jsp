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
    <title>$Title$</title>
</head>
<body>

<form class="form-signin" action="ProjectServlet" method="post">
    <h2 class="form-signin-heading">Пожалуйста авторизуйтесь</h2>
    <label>Email адрес</label>
    <input type="text" name="inputEmail"  placeholder="Email адрес" required autofocus>
    <label>Пароль</label>
    <input type="password" name="inputPassword" placeholder="Пароль" required>
    <input type="hidden" name="command" value="login">
    <button name="submitLogin" class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
</form>
</body>
</html>
