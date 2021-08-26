<?xml version="1.0" ?>
<%@ page pageEncoding="UTF-8" %>

<jsp:element name="data">
    <h3>Please view source of this page</h3>

    <%--  Tạo đối tượng Employee và set giá trị cho các field của nó --%>

    <jsp:useBean id="emp" class="com.example.tutorial.jsp.beans.Employee">
        <jsp:setProperty name="emp" property="empNo" value="E01"/>
        <jsp:setProperty name="emp" property="empName" value="Minh Duc"/>
    </jsp:useBean>

    <jsp:element name="employee">
        <jsp:attribute name="empNo" trim="true">
            <jsp:getProperty name="emp" property="empNo"/>
        </jsp:attribute>
        <jsp:body>
            <jsp:getProperty name="emp" property="empName"/>
        </jsp:body>
    </jsp:element>
</jsp:element>