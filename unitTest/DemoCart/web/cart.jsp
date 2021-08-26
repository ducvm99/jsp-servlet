<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<div align="center">
    <h1>Thong tin gio hang</h1>
    <table border="1" cellspacing="0">
        <tr>
            <td>Code</td>
            <td>Name</td>
            <td>Price</td>
        </tr>
        <c:set var="shop" value="${sessionScope.shop}"/>
        <c:if test="${not empty shop}">
            <table border="1" cellspacing="0">
                <thead>
                    <tr>
                        <td>No</td>
                        <td>Code</td>
                        <td>Name</td>
                        <td>Price</td>
                        <td>Quantity</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                    <form action="ControllerCart" method="get">
                        <c:set var="count" value="0"/>
                        <c:forEach var="row" items="${shop}">
                            <c:set var="count" value="${count + 1}"/>
                            <tr>
                                <td>${count}</td>
                                <td>${row.value.product.code}</td>
                                <td>${row.value.getProduct().getName()}</td>
                                <td>${row.value.getProduct().getPrice()}</td>
                                <td>${row.value.getQuantity()}</td>
                                <td><input type="checkbox" name="remove" value="${row.value.getProduct().getCode()}"></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <c:url var="add" value="Controller">
                                <c:param name="action" value="AddMore"/>
                            </c:url>
                            <td colspan="2"><a href="${add}">Add More</a></td>
                            <td><input type="submit" value="Remove" name="action"></td>
                        </tr>
                    </form>
                </tbody>
            </table>
        </c:if>
    </table>
</div>
</body>
</html>
