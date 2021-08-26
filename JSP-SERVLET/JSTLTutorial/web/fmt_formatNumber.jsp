<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fmt:formatNumber example</title>
</head>
<body>
<h2>fmt:formatNumber example</h2>

<c:set var="accountBalance" value="12345.6789"/>
<h3>accountBalance = <c:out value="${accountBalance}"/></h3>

The Account Balance can be displayed using various ways:

<p>
    formatNumber (type='currency'):
    <strong>
        <fmt:formatNumber value="${accountBalance}" type="currency"/>
    </strong>
</p>

<p>
    formatNumber (type='number', maxIntegerDigits='3'):
    <strong>
        <fmt:formatNumber value="${accountBalance}" type="number" maxFractionDigits="3"/>
    </strong>
</p>

<p>
    formatNumber (type='number', groupingUsed='false'):
    <strong>
        <fmt:formatNumber value="${accountBalance}" type="number" groupingUsed="false"/>
    </strong>
</p>

<p>
    formatNumber (type='percent', maxIntegerDigits='3'):
    <strong>
        <fmt:formatNumber value="${accountBalance}" type="percent" maxIntegerDigits="3"/>
    </strong>
</p>

<p>
    formatNumber (type='percent', minFractionDigits='10'):
    <strong>
        <fmt:formatNumber value="${accountBalance}" type="percent" minFractionDigits="10"/>
    </strong>
</p>

<p>
    formatNumber (type='number', pattern='###.###E0):
    <strong>
        <fmt:formatNumber value="${accountBalance}" type="number" pattern="###.###E0"/>
    </strong>
</p>

<p>
    Account Balance in USA (fmt:setLocale value='en_US'):
    <br>
    formatNumber (type='currency'):
    <fmt:setLocale value="en_US"/>
    <strong>
        <strong><fmt:formatNumber value="${accountBalance}" type="currency"/></strong>
    </strong>
</p>

<p>
    Account Balance in Canada (fmt:setLocale value='fr_CA')
    <br>
    formatNumber (type='currency'):
    <fmt:setLocale value="fr_CA"/>
    <strong>
        <fmt:formatNumber value="${accountBalance}" type="currency"/>
    </strong>
</p>


</body>
</html>
