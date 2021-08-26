<%@ page isELIgnored="false" %>
<%@ page import="demo.models.Image" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="inc/banner.jsp" %>

<%--    Image name: <%= ((Image) request.getAttribute("imageName")).getName() %>--%>
    Image name: ${requestScope.imageName}
    <br>
    <img src="public/images/girl2.jpg" alt="Demo image 2">
    <br>
    <% pageContext.setAttribute("scope", "Page Context"); %>
    Scope of the attribute: <%= pageContext.getAttribute("scope") %>
    <br>
<%--    Languages: ${requestScope["languages"]}--%>
    Languages: ${requestScope["languages"][1]}
<%--    Languages: ${requestScope.languages[1]}--%>
    <br>
    <% pageContext.setAttribute("scope", "Page Context"); %>
<%--    Scope of the attribute by EL: ${pageScope.scope} <!-- pageScope, requestScope, sessionScope, applicationScope -->--%>
    Scope of the attribute by EL: ${pageScope["scope"]}
    <br>
    <% pageContext.setAttribute("scope", "Page Context"); %>
    Scope of the attribute by EL: ${4 + 5}
    <br>
    Student name is: ${requestScope.student.name}
    <br>
<%--    <%= application.getInitParameter("account") %>--%>
    Account: ${initParam.account}
    <br>
    Scope of the request attribute: <%= pageContext.findAttribute("otherScope") %>
    <br>
    <%--    Scope of the session attribute: <%= pageContext.findAttribute("otherScope") %>--%>
    Scope of the session attribute: <%= pageContext.getAttribute("otherScope", PageContext.SESSION_SCOPE) %>
    <br>
    Scope of the application attribute: <%= pageContext.getAttribute("otherScope", PageContext.APPLICATION_SCOPE) %>
    <br>
    Scope of the request attribute: <%= pageContext.getAttribute("otherScope", PageContext.REQUEST_SCOPE) %>
    <br>
    <h3>Examples of Standard Actions</h3>
    <br>
<%--    <jsp:useBean id="student" class="demo.models.Student" scope="request"/>--%>
<%--    Get Property name: <jsp:getProperty name="student" property="name"/>--%>
    <br>
    <jsp:useBean id="student" class="demo.models.Student" scope="request">
        <jsp:setProperty name="student" property="name" value="Thuy Dung"/>
    </jsp:useBean>
    <br>
<%--    <jsp:setProperty name="student" property="name" value="Thu hang"/>--%>
    Get changed Property name : <jsp:getProperty name="student" property="name"/>


</body>
</html>
