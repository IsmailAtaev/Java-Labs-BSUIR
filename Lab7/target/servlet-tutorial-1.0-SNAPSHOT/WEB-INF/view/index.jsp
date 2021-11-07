<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<h1>Hello from Java Vision!</h1><br />

<h2>Вес текст</h2><br />

<c:forEach var="world" items="${requestScope.worlds}">
    <ul>

        <li>Текст: <c:out value="${world.text}"/></li>

        <li>Символ: <c:out value="${world.symbol}"/></li>
    </ul>
    <hr />

</c:forEach>

<h2> Ввод текста</h2><br />

<form method="post" action="">

    <label><input type="text" name="text"></label>Текст<br>

    <label><input type="text" name="symbol"></label>Символ<br>

    <input type="submit" value="swap" name="swap"><br>
</form>

</body>
</html>
