<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Kalkulator farby</title>
    </head>
    <body>
        <h1>Kalkulator farby</h1>
        <p>W Twoim pokoju do pomalowania jest ${paintArea} metrów kwadratowych</p>
        <p>Potrzebujesz do tego ${paintAmount} litrów wybranej farby</p>
        <a href="${pageContext.request.getContextPath()}">Powrót do kalkulatora</a>
    </body>
</html>
