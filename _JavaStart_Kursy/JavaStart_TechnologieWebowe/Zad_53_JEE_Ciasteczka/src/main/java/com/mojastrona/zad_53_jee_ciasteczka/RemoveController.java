package com.mojastrona.zad_53_jee_ciasteczka;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/remove")
public class RemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // żeby usunąć ciasteczko z przeglądarki musimy utworzyć ciasteczko
        // o identycznej nazwie jak ciasteczko, które chcemy usunąć, tutaj: "visits"
        // value nie ma znaczenia, bo i tak chcemy je usunąć
        Cookie removeVisitCookie = new Cookie("visits", "");

        // w celu usunięcia ciasteczka, musimy ustawić jego czas życia na 0:
        removeVisitCookie.setMaxAge(0);

        //dodajemy ciasteczko (wysyłamy odpowiedź do użytkownika):
        response.addCookie(removeVisitCookie);

        //ponieważ chcemy jakoś potwierdzić to, że ciasteczko zostało usunięte
        request.getRequestDispatcher("/removeConfirm.jsp").forward(request, response);
    }

}
