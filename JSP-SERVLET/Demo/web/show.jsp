<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/5/2021
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    The image name is: <%= request.getAttribute("imageName")%>
    <br>
    <img src="public/images/girl.jpg" alt="This is a show">
</body>
</html>
