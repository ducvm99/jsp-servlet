<%@ page import="java.util.Date" %>
<!-- Khai báo import -->
<%--<%@ page import="java.util.*, java.text.*" %>--%>
<%--<%@ page import="java.util.List, java.text.*" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JSP Tutorial</title>
  </head>
  <body>
  <h1>Hello JSP</h1>

  <%
    java.util.Date date = new java.util.Date();
  %>
  <h2>Now is <%= date.toString() %></h2>

  <%
    // Ví dụ sử dụng biến out.
    out.println("<h1>Now is " + new Date() + "</h1>");

    // Ví dụ sử dụng biến request
    String serverName = request.getServerName();

    out.println("Server name is " + serverName);

    // Ví dụ sử dụng biến response
//    response.sendRedirect("https://news.zing.vn");
  %>
  </body>
</html>
