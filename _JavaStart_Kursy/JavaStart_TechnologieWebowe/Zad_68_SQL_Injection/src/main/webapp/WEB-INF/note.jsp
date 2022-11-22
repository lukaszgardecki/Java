<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.note.title}</title>
</head>
<body>
    <h1>Notatka: ${requestScope.note.title}</h1>
    <p>Treść notatki:</p>
    <p>${requestScope.note.content}</p>
</body>
</html>
