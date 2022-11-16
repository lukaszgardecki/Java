<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
    <head>
        <title>Expression Language</title>
    </head>
    <body>
        <form action="" method="post">
            <fieldset>
                <div>
                    <label for="firstName">Imię</label>
                    <input name="firstName" id="firstName"/>
                </div>
                <div>
                    <label for="lastName">Nazwisko</label>
                    <input name="lastName" id="lastName"/>
                </div>
                <div>
                    <label for="age">Wiek</label>
                    <input name="age" type="number" id="age"/>
                </div>
                <div>
                    <label>Płeć</label>
                    <select name="gender" id="gender">
                        <option value="MALE">Mężczyzna</option>
                        <option value="FEMALE">Kobieta</option>
                    </select>
                </div>
            </fieldset>
            <input type="submit" value="Zapisz">
        </form>

    <ol>
        <c:forEach items="${applicationScope.people}" var="person">
            <li>
                ${fn:toUpperCase(person.firstName.concat(" ").concat(person.lastName))}
                    (${person.age} lat) / ${person.gender == 'MALE' ? 'Mężczyzna' : 'Kobieta'}
                <c:if test="${person.age ge 18}">
                    <span style="color: green">Pełnotleni(a)</span>
                </c:if>
                <c:if test="${person.age < 18}">
                    <span style="color: red">Nieletni(a)</span>
                </c:if>
            </li>
        </c:forEach>
    </ol>

    <h2>To co o Tobie wiemy:</h2>
    <h3>Ciasteczka (${fn:length(cookie)}):</h3>
    <c:forEach var="cookieItem" items="${cookie}">
        <p>${cookieItem.key} : ${cookieItem.value.value}</p>
    </c:forEach>

    <h3>Informacje z nagłówków (${fn:length(header)}):</h3>
    <c:forEach var="headerItem" items="${header}">
        <p>${headerItem.key} : ${headerItem.value}</p>
    </c:forEach>



    <c:if test="${not empty param.password}">
        <c:choose>
            <c:when test="${param.password eq 'java'}">
                <p>Java jest super najlepsza i w ogóle</p>
            </c:when>
            <c:when test="${param.password eq 'python'}">
                <p>Python jest fajny, ale Java jeszcze lepsza</p>
            </c:when>
            <c:otherwise>
                <p>Dla takiego hasła nie ma żadnej sekretnej wiadomości</p>
            </c:otherwise>
        </c:choose>
    </c:if>
    </body>
</html>
