<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL Core Tags Example 02</title>
</head>
<body>
<h2>Departments and Employees</h2>

<!-- Dùng for để duyệt trên các phòng ban (departments) -->
<c:forEach items="${requestScope.departments}" var="dept">
    <!-- Kiểm tra một tập hợp có phần tử không -->
    <c:if test="${not empty dept.employees}">
        <h3>${dept.deptName}</h3>
        <ul>
            <!-- Dùng for để duyệt trên các nhân viên thuộc phòng ban hiện tại -->
            <c:forEach items="${dept.employees}" var="emp">
                <li>
                    ${emp.empName} - ${emp.job}
                </li>
            </c:forEach>
        </ul>
    </c:if>
</c:forEach>
</body>
</html>
