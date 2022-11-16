<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Wspólny edytor</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>

    <script>
        tinymce.init({
            selector: '#mytextarea',
            height:'500',
        });
    </script>
</head>
<body>
<h1>Wspólny edytor</h1>
<p>Twórz dokument ze wszystkimi innymi. Dodaj coś od siebie!</p>
<form action="" method="post">
    <textarea id="mytextarea" name="text"><%=request.getAttribute("text")%></textarea>
    <button style="width: 100%; margin-top: 20px">Zapisz zmiany</button>
</form>
</body>
</html>