<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="UTF-8"
%>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>Page has Error</title>
</head>
<body>
    <h2>Page has Error</h2>

    <%
        // Error divided by 0
        int i = 1000 / 0;
    %>
</body>
</html>
