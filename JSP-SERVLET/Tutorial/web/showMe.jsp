<%@ page import="com.example.tutorial.beans.Constants" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/8/2021
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Text of ShowMeServlet</h2>
<p><%= pageContext.getAttribute(Constants.ATTRIBUTE_USER_NAME_KEY, PageContext.REQUEST_SCOPE) %></p>
</body>
</html>
