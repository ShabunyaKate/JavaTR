<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 18.07.2019
  Time: 0:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Таблица музыканты</title>
</head>
<body>
<form action="ProjectServlet" method="post">
    <label>Первый день</label>
    <label>
        <c:out value="${day0.date}"/>
        <table>
            <c:forEach items="${musicians0}" var="musician0" >
                <tr>
                    <td><c:out value="${musician0.user.login}"/></td>
                </tr>
            </c:forEach>
        </table>
    </label>
    <label>Второй день</label>
    <label>
        <c:out value="${day1.date}"/>
        <table>
            <c:forEach items="${musicians1}" var="musician1" >
                <tr>
                    <td><c:out value="${musician1.user.login}"/></td>
                </tr>
            </c:forEach>
        </table>
    </label>

</form>
</body>
</html>
