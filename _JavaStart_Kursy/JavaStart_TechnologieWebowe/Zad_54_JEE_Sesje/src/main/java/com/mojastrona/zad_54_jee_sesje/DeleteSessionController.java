package com.mojastrona.zad_54_jee_sesje;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/deletesession")
public class DeleteSessionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //Sposób 1:
//        //w celu usunięcia sesji, na obiekcie request odwołujemy się do sesji i wykonujemy metodę invalidate():
//        request.getSession().invalidate();

        //Sposób 2:
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
