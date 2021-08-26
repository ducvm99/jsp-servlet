<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>c:remove example</title>
</head>
<body>
<h2>c:remove example</h2>

<c:set scope="request" var="greeting" value="Hello every body"/>

Greeting: <c:out value="${greeting}"/>
<br>
<c:remove scope="request" var="greeting"/>
After remove:
<br>
Greeting: <c:out value="${greeting}"/>
</body>
</html>
