<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>c:catch example</title>
</head>
<body>
<h2>c:catch example</h2>

<c:catch var="ex">
    <%
        int a = 100 / 0;
    %>
</c:catch>

<c:if test="${ex != null}">
    Exception: ${ex}
    <br>
    Message: ${ex.message}
</c:if>
</body>
</html>
