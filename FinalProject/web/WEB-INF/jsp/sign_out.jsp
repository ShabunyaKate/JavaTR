<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 18.07.2019
  Time: 3:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Sign out</title>
</head>
<body>
<form action="/ProjectServlet" method="post">
    <input type="hidden" name="command" value="sign_out">
    <button class="btn btn-lg btn-primary btn-block" type="submit">выйти</button>
</form>
</body>
</html>
