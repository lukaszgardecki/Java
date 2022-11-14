<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Błąd</title>
  </head>
  <body>
    <h2>Wystąpił błąd</h2>
    <p><%= request.getAttribute("message")%></p>
  </body>
</html>
