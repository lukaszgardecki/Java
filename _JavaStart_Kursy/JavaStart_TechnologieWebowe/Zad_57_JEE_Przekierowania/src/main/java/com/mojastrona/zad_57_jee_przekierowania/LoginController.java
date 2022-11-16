package com.mojastrona.zad_57_jee_przekierowania;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // odbieramy parametry
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //sprawdzamy, czy podane w formularzu dane są właściwe
        // w zależności od tego czy są poprawne, czy też nie, przekazujemy żądanie
        // do strony adminPage.jsp lub error.jsp
        if ("admin".equals(username) && "admin".equals(password)) {
            request.getSession().setAttribute("username", username);
            //request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
            response.sendRedirect("admin");
        } else {
            //request.getRequestDispatcher("/error.jsp").forward(request, response);
            response.sendRedirect("error.jsp");
        }
    }
}
