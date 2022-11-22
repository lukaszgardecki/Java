package com.example.zad_69_basicauthentication_calculator.logout;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // usunięcie kontektu bezpieczeństwa, sesja będzie nadal istnieć
        request.logout();

//        //usunięcie sesji wraz z powiązanym kontekstem bezpieczeństwa
//        request.getSession().invalidate();

        // przekierowanie z powrotem do strony głównej:
        response.sendRedirect(request.getContextPath());
    }

}
