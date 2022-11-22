<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kalkulator</title>
</head>
<body>
    <h2>Kalkulator</h2>

<%--    Wyświetlanie nazwy użytkownika, sposób 1:--%>
    <p>Jesteś zalogowany jako ${pageContext.request.remoteUser}</p>
<%--    Wyświetlanie nazwy użytkownika, sposób 2:--%>
<%--    <p>Jesteś zalogowany jako ${pageContext.request.userPrincipal.name}</p>--%>

    <form action="${pageContext.request.contextPath}/calculator" method="post">
        <fieldset>
            <legend>Wprowadź liczby i wybierz operator</legend>
            <input type="number" name="first">
            <select name="operator">
                <option value="+">+</option>
                <option value="-">-</option>
                <option value="*">*</option>
                <option value="/">/</option>
            </select>
            <input type="number" name="second">
        </fieldset>
        <button type="submit">Oblicz</button>
    </form>
<%--    Możliwość wylogowania się np. przy użyciu odnośnika --%>
    <a href="${pageContext.request.contextPath}/logout">Wyloguj się</a>
</body>
</html>
