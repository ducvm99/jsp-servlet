<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${not empty param.language}">
    <c:set var="language" value="${param.language}" scope="session"/>
</c:if>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="com.example.jstlTurorial.bundles.MyBundle"/>
<html>
<head>
    <title>fmt:bundle example</title>
</head>
<body>
<h2>fmt:bundle example</h2>
<form action="">
    <table border="0">
        <tr>
            <td>
                <fmt:message key="login.label.username"/>
            </td>
            <td>
                <input type="text" name="userName">
            </td>
        </tr>
        <tr>
            <td>
                <fmt:message key="login.label.password"/>
            </td>
            <td>
                <input type="text" name="password">
            </td>
        </tr>
    </table>
    <input type="submit" value="Submit">
</form>
</body>
</html>
