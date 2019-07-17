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
    <title>Регистрация пользователя</title>
</head>
<body>
<form  action="ProjectServlet" method="post">
    <label>Введите имя</label>
    <input type="text" name="name"  placeholder="name" required autofocus>
    <label>Введите фамилию</label>
    <input type="text" name="surname"  placeholder="surname" required autofocus>
    <label>Введите дату рождения</label>
    <input type="date" name="birthday"  placeholder="birthday" required autofocus>
    <label>Введите email</label>
    <input type="email" name="email"  placeholder="email" required autofocus>
    <label>Введите номер телефона</label>
    <input type="text" name="phone"  placeholder="phone" required autofocus>
    <label>Введите логин</label>
    <input type="text" name="login"  placeholder="логин" required autofocus>
    <label>Введите пароль</label>
    <input type="password" name="password" placeholder="Пароль" required>
    <input type="hidden" name="command" value="registration">
    <button name="submitLogin" class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
</form>
</body>
</html>
