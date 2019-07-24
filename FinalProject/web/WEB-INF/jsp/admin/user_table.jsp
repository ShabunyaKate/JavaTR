<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 18.07.2019
  Time: 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Таблица юзеров</title>
</head>
<body>
<form action="ProjectServlet" method="post">
    <label>
        <table>
            <c:forEach items="${users}" var="user" >
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.login}"/></td>
                    <td><c:out value="${user.userInfo.name}"/></td>
                    <td><c:out value="${user.userInfo.surname}"/></td>
                    <td><c:out value="${user.userInfo.email}"/></td>
                    <td><c:out value="${user.userInfo.phone}"/></td>
                </tr>
            </c:forEach>
        </table>
    </label>
</form>
<form action="/ProjectServlet" method="post">
    <input type="text" name="user_delete" placeholder="пользователь" required>
    <input type="hidden" name="command" value="delete_user">
    <button class="btn btn-lg btn-primary btn-block" type="submit">удалить</button>
</form>
</body>
</html>
