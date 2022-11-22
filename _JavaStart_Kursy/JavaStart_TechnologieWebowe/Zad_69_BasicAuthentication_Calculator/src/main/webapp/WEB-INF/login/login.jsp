<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zaloguj się</title>
</head>
<body>
  <h1>Zaloguj się</h1>
  <form action="j_security_check" method="post">
    <fieldset>
      <legend>Wprowadź swoje dane</legend>
      <div>
        <label for="username">Nazwa użytkownika</label>
        <input name="j_username" placeholder="username" id="username"/>
      </div>
      <div>
        <label for="password">Hasło</label>
        <input name="j_password" placeholder="password" type="password" id="password"/>
      </div>
    </fieldset>
    <button type="submit">Zaloguj się</button>
  </form>
</body>
</html>
