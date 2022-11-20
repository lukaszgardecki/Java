<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szczegóły produktu</title>
</head>
<body>

<%--import statyczny:--%>
<%--<%@ include file="header.jspf"%>--%>

<%--import dynamiczny:--%>
<jsp:include page="segments/header.jspf"/>

<main>
    <h1>Szablon strony produktu</h1>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
        eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
        minim veniam, quis nostrud exercitation ullamco laboris nisi ut
        aliquip ex ea commodo consequat. Duis aute irure dolor in
        reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
        pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
        culpa qui officia deserunt mollit anim id est laborum</p>
</main>
<%--import statyczny:--%>
<%--<%@ include file="footer.jspf"%>--%>

<%--import dynamiczny:--%>
<jsp:include page="segments/footer.jspf"/>
</body>
</html>
