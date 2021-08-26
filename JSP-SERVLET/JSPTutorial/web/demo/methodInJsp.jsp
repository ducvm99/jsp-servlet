<%!
    public int sum(int a, int b) {
        return a + b;
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Method in Jsp</title>
</head>
<body>
    <h1>1 + 2 = <%= sum(1, 2) %></h1>
</body>
</html>
