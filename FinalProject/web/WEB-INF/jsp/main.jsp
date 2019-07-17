<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 07.07.2019
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form class="form-signin" action="ProjectServlet" method="post">
    <label>Email адрес</label>
    <label>
      <c:out value="${user.login}"/>
    </label>
    <label>Пароль</label>
    <label>
      <c:out value="${user.password}"/>
    </label>
    <label>Role</label>
    <label>
      <c:out value="${user.role}"/>
    </label>

  </form>
  </body>
</html>
