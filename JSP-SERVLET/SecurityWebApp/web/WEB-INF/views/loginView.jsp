<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>

<h3>Login Page</h3>

<p style="color: red;">${errorString}</p>

<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="hidden" name="redirectId" value="${param.redirectId}">
    <table border="0">
        <tr>
            <td>Username</td>
            <td><input type="text" name="userName" value="${user.userName}"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" value="${user.password}"></td>
        </tr>
        <tr>
            <td colspan="-2">
                <input type="submit" value="Submit">
                <a href="${pageContext.request.contextPath}/">Cancel</a>
            </td>
        </tr>
    </table>
</form>

<p style="color:blue;">Login with:</p>

employee1/123 <br>
manager1/123
</body>
</html>
