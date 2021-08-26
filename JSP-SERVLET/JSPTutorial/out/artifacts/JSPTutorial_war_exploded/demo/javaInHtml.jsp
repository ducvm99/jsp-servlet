<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Java in HTML</title>
</head>
<body>
<%
    Random random = new Random();

    // Trả về ngẫu nhiên (0, 1 hoặc 2).
    int randomInt = random.nextInt(3);
    
    if (randomInt == 0) {
%>
    <h1>Random value 0 = <%= randomInt %></h1>

<% 
    } else if (randomInt == 1) { 
%>
    <h1>Random value 1 = <%= randomInt %></h1>
<%
    } else {
%>
    <h1>Random value 2 = <%= randomInt %></h1>
<%
    }
%>

<a href="<%= request.getRequestURI() %>">Try again</a>
</body>
</html>
