<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>c:forTokens example</title>
</head>
<body>
<h2>c:forTokens example</h2>

<c:forTokens items="Tom,Jerry,Bulk" delims="," var="name">
    <c:out value="${name}"/> <br>
</c:forTokens>
</body>
</html>
