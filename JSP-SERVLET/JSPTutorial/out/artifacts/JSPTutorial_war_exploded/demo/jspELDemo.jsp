<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/9/2021
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Expression Language Demo</title>
</head>
<body>
<jsp:useBean id="emp" class="com.example.tutorial.jsp.beans.Employee">
    <jsp:setProperty name="emp" property="empNo" value="E01"/>
    <jsp:setProperty name="emp" property="empName" value="Minh Duc"/>
</jsp:useBean>

<br>
Emp No: <input type="text" value="${emp.empNo}">
<br>
Emp Name: <input type="text" value="${emp.empName}">
</body>
</html>
