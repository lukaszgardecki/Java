package com.mojastrona.zad_46_jee;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/divisors")
public class DivisorsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nParam = request.getParameter("n");
        if (nParam == null || "".equals(nParam)) {
            response.sendError(400, "Brak parametru N");
        } else {
            int n = Integer.parseInt(nParam);
            String responseBody = createHtmlResponse(n);
            setContentType(response);
            response.getWriter().println(responseBody);
        }
    }

    private String createHtmlResponse(int n) {
        List<Integer> divisors = getDivisorsOf(n);
        StringBuilder divisorsList = new StringBuilder();
        if (n == 0) divisorsList.append("<li>Liczba 0 ma nieskończenie wiele dzielników</li>");
        for (Integer divisor : divisors) {
            divisorsList.append("<li>").append(divisor).append("</li>");
        }
        String responseBody =
                """
                <html>
                    <body>
                        <h1>Podzielniki liczby %d</h1>
                        <ul>
                            %s
                        </ul>
                    </body>
                </html>
                """;
        return String.format(responseBody, n, divisorsList);
    }

    private static void setContentType(HttpServletResponse response) {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
    }

    private List<Integer> getDivisorsOf(int n) {
        return new DivisorsFinder().getDivisorsOf(n);
    }
}
