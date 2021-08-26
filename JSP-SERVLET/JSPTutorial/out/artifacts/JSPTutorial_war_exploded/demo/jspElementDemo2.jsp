<?xml version="1.0" ?>
<%@ page pageEncoding="UTF-8"%>

<data>

    <h3>Please view source of this page</h3>

    <%--  Tạo đối tượng Employee và sét giá trị cho các field của nó --%>

    <jsp:useBean id="emp"
                 class="org.o7planning.tutorial.jsp.beans.Employee">

        <jsp:setProperty name="emp" property="empNo" value="E01" />
        <jsp:setProperty name="emp" property="empName" value="Smith" />

    </jsp:useBean>

    <employee empNo="<%=emp.getEmpNo()%>">
        <%=emp.getEmpName()%>
    </employee>

</data>