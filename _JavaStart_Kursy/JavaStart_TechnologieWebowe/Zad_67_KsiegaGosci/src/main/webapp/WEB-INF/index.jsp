<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
      <title>Księga gości</title>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
  </head>
  <body>
        <main>
            <section class="form">
                <h1>Księga gości</h1>
                <form method="post">
                    <fieldset>
                        <legend>Zostaw po sobie ślad</legend>
                        <label>Twoja nazwa
                            <input name="author" placeholder="Jan Kowalski" required>
                        </label>
                        <label for="text">Treść wiadomości</label>
                        <textarea id="text" name="text" placeholder="Zacznij pisać..." rows="5" required></textarea>
                        <button>Wyślij</button>
                    </fieldset>
                </form>
            </section>

            <c:if test="${not empty requestScope.visits}">
                <section class="visit">
                    <h2>Wasze wpisy (${requestScope.visits.size()})</h2>
                    <c:forEach var="visit" items="${requestScope.visits}">
                        <div class="visit">
                            <h2>Autor: <c:out value="${visit.author}"/></h2>
                            <p><c:out value="${visit.text}"/></p>
                        </div>

                    </c:forEach>
                </section>
            </c:if>
        </main>
  </body>
</html>
