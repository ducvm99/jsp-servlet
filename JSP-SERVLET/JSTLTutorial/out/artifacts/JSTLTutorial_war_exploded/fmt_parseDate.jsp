<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fmt:parseDate example</title>
</head>
<body>
<h2>fmt:parseDate example</h2>

<!-- Một chuỗi có định dạng ngày tháng thời gian -->
<c:set var="dateTimeString" value="10-8-2021 4:10"/>
<h4>
    dateTimeString:
    <c:out value="${dateTimeString}"/>
</h4>
<!-- Phân tích chuỗi mô tả ngày tháng thời gian lưu vào biến kiểu java.util.Date -->

<fmt:parseDate value="${dateTimeString}" type="both" var="parsedDatetime" pattern="dd-MM-yyyy HH:mm"/>
<p>
    The date time after parsing:
    <c:out value="${parsedDatetime}"/>
</p>
<br>
<p>
    Date only (dd/MM/yyyy):
    <fmt:formatDate value="${parsedDatetime}" var="parsedDatetime" pattern="dd/MM/yyyy"/>
    <c:out value="${parsedDatetime}"/>
</p>
</body>
</html>
