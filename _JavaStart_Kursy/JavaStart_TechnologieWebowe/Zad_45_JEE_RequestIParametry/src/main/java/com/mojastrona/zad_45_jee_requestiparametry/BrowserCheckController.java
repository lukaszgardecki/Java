package com.mojastrona.zad_45_jee_requestiparametry;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;

@WebServlet("/browser")
public class BrowserCheckController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printUserAgent(request);
        System.out.println("----------");
        printAllHeaders(request);
    }

    private void printAllHeaders(HttpServletRequest request) {
        System.out.println("Wszystkie nagłówki:");
        Enumeration<String> headerNames = request.getHeaderNames();

//        // Sposób wyświetlenia przy użyciu pętli:
//        while (headerNames.hasMoreElements()) {
//            String nextElement = headerNames.nextElement();
//            System.out.println(nextElement + " " + request.getHeader(nextElement));
//        }

        // Sposób wyświetlenia przy użyciu strumieni:
        Collections.list(headerNames).stream()
                .map(name -> name + " " + request.getHeader(name))
                .forEach(System.out::println);
    }

    private static void printUserAgent(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        System.out.println("Przeglądarka klienta: " + userAgent);
    }

}
