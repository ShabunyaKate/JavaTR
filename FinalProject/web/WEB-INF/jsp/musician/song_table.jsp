<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 18.07.2019
  Time: 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Песни исполнителя</title>
</head>
<body>
<form action="ProjectServlet" method="post">
    <label><c:out value="${musician.user.login}"/></label>
    <label>
        <table>
            <c:forEach items="${songs}" var="song" >
                <tr>
                    <td><c:out value="${song.name}"/></td>
                </tr>
            </c:forEach>
        </table>
    </label>
</form>
<form action="/ProjectServlet" method="post">
    <input type="song" name="song" placeholder="Песня" required>
    <input type="hidden" name="command" value="add_song">
    <button name="submitLogin" class="btn btn-lg btn-primary btn-block" type="submit">добавить песню</button>
    </form>
<form action="/ProjectServlet" method="post">
    <input type="song" name="song" placeholder="Песня" required>
    <input type="hidden" name="command" value="delete_song">
    <button name="submitLogin" class="btn btn-lg btn-primary btn-block" type="submit">удалить песню</button>
</form>
</body>
</html>
