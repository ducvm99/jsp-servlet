<%@ page import="com.example.tutorial.jsp.utils.CookieUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie Demo</title>
</head>
<body>
<%
    CookieUtils.demoUserCookie(request, response, out);
%>

<a href="">Try again!</a>
</body>
</html>
