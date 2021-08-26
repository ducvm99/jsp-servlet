<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>

<h3>Hello: ${loggedUser.userName}</h3>
User Name: <b>${loggedUser.userName}</b>
<br>
Gender: ${loggedUser.gender}
</body>
</html>
