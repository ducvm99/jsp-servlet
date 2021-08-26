<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fmt:formatDate example</title>
</head>
<body>
<h2>fmt:formatDate example</h2>
<c:set var="now" value="<%= new java.util.Date() %>"/>
<p>
    Time (fmt:formatDate type="time"):
    <strong>
        <fmt:formatDate value="${now}" type="time"/>
    </strong>
</p>
<p>
    Date (fmt:formatDate type="Date"):
    <strong>
        <fmt:formatDate value="${now}" type="date"/>
    </strong>
</p>
<p>
    Date, Time (fmt:formatDate type="both"):
    <strong>
        <fmt:formatDate value="${now}" type="both"/>
    </strong>
</p>
<p>
    Date, Time Short (fmt:formatDate type="both" dateStyle="short"):
    <strong>
        <fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short"/>
    </strong>
</p>
<p>
    Date, Time Medium (fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"):
    <strong>
        <fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium"/>
    </strong>
</p>
<p>
    Date, Time Long (fmt:formatDate type="both" dateStyle="long" timeStyle="long"):
    <strong>
        <fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long"/>
    </strong>
</p>
<p>
    Date, Time (dd-MM-YYYY HH:mm:ss):
    <strong>
        <fmt:formatDate value="${now}" pattern="dd-MM-yyyy HH:mm:ss"/>
    </strong>
</p>
<!-- Store in variable -->
<fmt:formatDate value="${now}" var="nowString" pattern="dd-MM-yyyy HH:mm"/>

<p>
    Now String (dd-MM-yyyy HH:mm):
    <strong>
        <c:out value="${nowString}"/>
    </strong>
</p>
</body>
</html>
