<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Use Bean</title>
</head>
<body>
<jsp:useBean id="helloBean" class="com.example.tutorial.jsp.beans.HelloBean"/>

<h3>Say Hello: </h3>
<jsp:getProperty name="helloBean" property="hello"/>

<!-- Set property name for helloBean -->
<jsp:setProperty name="helloBean" property="name" value="JSP"/>
<h3>Say Hello after setName</h3>
<jsp:getProperty name="helloBean" property="hello"/>
</body>
</html>
