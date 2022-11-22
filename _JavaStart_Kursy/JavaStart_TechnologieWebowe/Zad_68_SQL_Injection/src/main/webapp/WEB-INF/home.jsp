<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tajne notatki - strona główna</title>
    <style>
      form div > * {
        display: block;
        width: 400px;
      }
    </style>
</head>
<body>
    <h1>Tajne notatki</h1>
    <p>Stwórz tajną notatkę i o nic się nie martw</p>
    <form action="${pageContext.request.contextPath}/save" method="post">
        <div>
            <label for="title">Tytuł (url) notatki</label>
            <input name="title" id="title">
        </div>
        <div>
            <label for="password">Hasło</label>
            <input name="password" id="password" type="password" placeholder="*****">
        </div>
        <div>
            <label for="content">Treść</label>
            <textarea name="content" id="content" placeholder="Treść notatki" rows="10"></textarea>
        </div>
        <button type="submit">Zapisz</button>
    </form>
</body>
</html>
