<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
</head>
<body>

<jsp:include page="inc/_header.jsp"/>
<jsp:include page="inc/_menu.jsp"/>

<h3>Hello: ${user.userName}</h3>

User Name: <b>${user.userName}</b>
<br />
Gender: ${user.gender } <br />

<jsp:include page="inc/_footer.jsp"/>

</body>
</html>