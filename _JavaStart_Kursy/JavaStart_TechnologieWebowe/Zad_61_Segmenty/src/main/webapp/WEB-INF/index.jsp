<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Strona główna</title>
    </head>
    <body>
<%--        import statyczny:--%>
<%--        <%@ include file="header.jspf"%>--%>

<%--        import dynamiczny:--%>
        <jsp:include page="segments/header.jspf"/>
        <main>
            <h1>Strona główna</h1>
            <p>Witamy na stronie głównej naszego sklepu</p>
            <p>Kupisz u nas m.in.:</p>
            <ul>
                <c:forEach var="product" items="${requestScope.products}">
                    <li><c:out value="${product}"/></li>
                </c:forEach>
            </ul>
        </main>
<%--        import statyczny:--%>
<%--        <%@ include file="footer.jspf"%>--%>

<%--        import dynamiczny:--%>
        <jsp:include page="segments/footer.jspf"/>

    </body>
</html>
