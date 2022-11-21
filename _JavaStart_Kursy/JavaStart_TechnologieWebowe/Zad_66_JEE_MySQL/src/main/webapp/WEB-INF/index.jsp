<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
      <title>Książka kucharska</title>
      <style>
        .recipe {
          border-style: solid;
          border-width: 1px;
          margin: 20px;
          padding: 20px;
        }
      </style>
  </head>
  <body>
      <h1>Książka kucharska</h1>
      <c:forEach var="recipe" items="${requestScope.recipes}">
        <section class="recipe">
            <h2><c:out value="${recipe.title}"/></h2>
            <p>Czas przygotowania: ${recipe.prepTime}</p>
            <h3>Składniki</h3>
            <p><c:out value="${recipe.ingredients}"/></p>
            <h3>Sposób przygotowania</h3>
            <p><c:out value="${recipe.description}"/></p>
        </section>
      </c:forEach>
  </body>
</html>
