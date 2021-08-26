<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/6/2021
  Time: 12:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
    <form action="detail.jsp" method="get">
        Student name: <input type="text" name="name">
        <br>
        Region:
        <select name="region">
            <option value="asia">Asia</option>
            <option value="america">America</option>
            <option value="europe">Europe</option>
        </select>
        <input type="submit" value="submit">
    </form>
</body>
</html>
