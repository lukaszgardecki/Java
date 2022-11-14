<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Youtuber</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
    <%
        String[] videos = request.getParameterValues("video");
        if (videos == null) {
            out.println("<h2>Brak parametru wideo w adresie URL</h2>");
        } else {
            for (String videoId : videos) {
    %>

        <iframe width="560" height="315" src="https://www.youtube.com/embed/<%=videoId%>" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

    <%
            }
        }
    %>
    </body>
</html>