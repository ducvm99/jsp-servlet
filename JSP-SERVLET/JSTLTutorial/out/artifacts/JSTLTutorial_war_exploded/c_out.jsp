<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>c:out example</title>
</head>
<body>
<h2>c:out example</h2>

<c:out value="${'This is true: 10 > 1'}"/>

<br>

Tag: <c:out value="${'<atag>, &'}"/>

</body>
</html>
