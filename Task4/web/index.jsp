<%--
  Created by IntelliJ IDEA.
  User: 21kat
  Date: 02.07.2019
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Парсинг Xml</title>
</head>
<body>
<form name="Simple" action="parse" method="POST">
  Введите имя файла
  <input name="name" />
  Выберите парсер
  <select name="parser">
    <option>Dom</option>
    <option>Sax</option>
    <option>Stax</option>
  </select>
  <input type="submit" name="button" value="Submit"/>
</form>
</select>
</body>
</html>
