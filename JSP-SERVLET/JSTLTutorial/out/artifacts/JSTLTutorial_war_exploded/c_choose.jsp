<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>c:choose, c:when, c:otherwise example</title>
</head>
<body>
<h2>c:choose, c:when, c:otherwise example</h2>

<c:choose>
    <%-- Khi tham số color == 'red' --%>
    <c:when test="${param.color == 'red'}">
        <p style="color: red;">RED COLOR</p>
    </c:when>
    <%-- Khi tham số color == 'blue' --%>
    <c:when test="${param.color == 'blue'}">
        <p style="color: blue;">RED BLUE</p>
    </c:when>
    <%-- Các trường hợp khác --%>
    <c:otherwise>
        <b>OTHER COLOR</b>
    </c:otherwise>
</c:choose>
</body>
</html>
