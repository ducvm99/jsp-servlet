<%--chua cac the, dung de them vao cac the, hoac tu tao ra de su dung--%>
<%--<%@ taglib prefix="" tagdir="" %> prefix: tien to, tagdir: vi tri trong thu muc--%>
<%--<%@ taglib prefix="" uri="" %> uri: link de xac dinh vi tri--%>
<%--ho tro cho viec su dung lai (reuse) header, footer, ...--%>
<%--<%@ include file=""  %>--%>
<%--them cac package--%>
<%--<%@ page import="package_path" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo</title>
</head>
<body>
<%--    <%@ include file="../inc/banner.jsp" %>--%>
<%! String bannerName = "Helllo world"; %>

    <jsp:include page="/inc/banner.jsp">
<%--        <jsp:param name="bannerName" value="Helllo world"/>--%>
<%--        <jsp:param name="bannerName" value="<%= 5 %>"/>--%>
        <jsp:param name="bannerName" value="<%= bannerName %>"/>
    </jsp:include>

    <h3>This is simple</h3>
    <br>
    this is Blog <%= config.getInitParameter("blog") %>
<%--    <%= request %>--%>
<%--    <%= response %>--%>
<%--    <%= config %>--%>
<%--    <%= application.getInitParameter() %>--%>
<%--    <% out.println(); %>--%>
<%--    <% pageContext.getException(); %>--%>
<%--        <% session.getAttribute() %>--%>
</body>
</html>
