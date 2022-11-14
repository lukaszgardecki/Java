<%@ page import="com.mojastrona.zad_51_jee_mvc.ExchangeResult" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="com.mojastrona.zad_51_jee_mvc.ExchangeType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Kalkulator walut - wynik</title>
    </head>
    <body>
        <%
            ExchangeResult exchangeResult = (ExchangeResult) request.getAttribute("result");
            BigDecimal base = exchangeResult.getBase();
            BigDecimal result = exchangeResult.getResult();
            ExchangeType exchangeType = exchangeResult.getExchangeType();
            String baseCurrency = exchangeType.getBaseCurrency();
            String targetCurrency = exchangeType.getTargetCurrency();
        %>
        <h2>
            <%= String.format("%s%s to %s%s", base.toString(), baseCurrency, result.toString(), targetCurrency)%>
        </h2>
    </body>
</html>
