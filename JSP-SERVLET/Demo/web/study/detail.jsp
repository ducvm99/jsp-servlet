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
    <title>Student Detail</title>
</head>
<body>
    <jsp:useBean id="student" type="demo.models.Person" class="demo.models.Student">
        <jsp:setProperty name="student" property="*"/>
<%--        <jsp:setProperty name="student" property="name"/>--%>
    </jsp:useBean>
    <br>
    Student name : <jsp:getProperty name="student" property="name"/>
<%--    <br>--%>
<%--    Student name: <%= request.getParameter("name") %>--%>
<%--    Student name: ${param.name}--%>
<%--    <br>--%>
<%--    Region: <%= request.getParameter("region") %>--%>
<%--    Region: ${param.region}--%>
</body>
</html>
