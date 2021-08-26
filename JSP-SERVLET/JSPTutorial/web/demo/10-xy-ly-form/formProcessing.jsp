<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/9/2021
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Processing</title>
</head>
<body>
<h3>Parameter values:</h3>
<%
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String gender = request.getParameter("gender");

    String[] addresses = request.getParameterValues("address");

%>

User Name: <%= userName %>
Password: <%= password %>
First Name: <%= firstName %>
Last Name: <%= lastName %>
Gender: <%= gender %>

<% if (addresses != null) {
    for (String address: addresses) { %>
        Address: <%= address %>
<% } } %>
</body>
</html>
