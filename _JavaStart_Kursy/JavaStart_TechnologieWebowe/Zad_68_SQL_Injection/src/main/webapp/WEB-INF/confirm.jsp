<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notatka zapisana</title>
</head>
<body>
    <h1>Twoja notatka została zapisana</h1>
    <p>Możesz ją zobaczyć <a href="${pageContext.request.contextPath}/note?title=${requestScope.note.title}">tutaj</a></p>
</body>
</html>
