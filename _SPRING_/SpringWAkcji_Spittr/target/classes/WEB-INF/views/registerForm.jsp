<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ page session="false" contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <title>Spittr</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>" >
    </head>
    <body>
        <h1>Rejestracja</h1>
        <sf:form method="post" name="spitter">
            <sf:errors path="*" element="div" cssClass="errors"/><br/>

            <sf:label path="firstName" cssErrorClass="error">Imię:</sf:label>
            <sf:input path="firstName" cssErrorClass="error"/><br/>

            <sf:label path="lastname" cssErrorClass="error">Nazwisko:</sf:label>
            <sf:input path="lastName" cssErrorClass="error"/><br/>

            <sf:label path="username" cssErrorClass="error">Nazwa użytkownika:</sf:label>
            <sf:input path="username" cssErrorClass="error"/><br/>

            <sf:label path="password" cssErrorClass="error">Hasło:</sf:label>
            <sf:password path="password" cssErrorClass="error"/><br/>

            <input type="submit" value="Zarejestruj">
        </sf:form>
    </body>
</html>