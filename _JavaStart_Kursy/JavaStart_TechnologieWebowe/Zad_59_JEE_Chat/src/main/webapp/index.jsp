<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JavaCzat</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <header>
            <h1>Witaj na JavaCzacie!</h1>
            <p>Poniżej widzisz historię konwersacji, możesz do niej dołączyć</p>
        </header>


        <main>
            <c:if test="${not empty messageHistory}">
                <ul class="message-list">
                    <c:forEach var="message" items="${messageHistory}">
                        <li><c:out value="${message}"/></li>
                    </c:forEach>
                </ul>
            </c:if>
            <c:if test="${empty messageHistory}">
                <p>Nie przesłano jeszcze żadnej wiadomości. Rozpocznij konwersację.</p>
            </c:if>


            <form action="" method="post">
                <textarea name="message" placeholder="Twoja wiadomość" rows="5" required></textarea>
                <input name="author" placeholder="Twoja nazwa" required>
                <button>Wyślij</button>
            </form>
        </main>
    </body>
</html>