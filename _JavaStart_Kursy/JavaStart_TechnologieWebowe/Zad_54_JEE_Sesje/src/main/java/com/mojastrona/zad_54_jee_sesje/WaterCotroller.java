package com.mojastrona.zad_54_jee_sesje;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/control")
public class WaterCotroller extends HttpServlet {
    private static final int GLASS_OF_WATER = 250;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // pobieramy parametr option zdefiniowany w formularzu index.html
        String option = request.getParameter("option");

        //w celu utworzenia sesji lub pobrania istniejącej sesji:
        HttpSession session = request.getSession();

        //mamy dwa przyciski z parametrem option
        //jeden ma wartość water, drugi ma wartość clear
        if (option.equals("water")) {
            increaseWaterLevel(session);
        } else if (option.equals("clear")) {
            session.removeAttribute("water");
        }

        // niezależnie, która zostanie wybrana opcja, chcemy znowu wyświetlić stronę główną
        // tak aby użytkownik mógł znowu wybrać odpowiednią opcję
        // więc korzystamy z dyspozytora żądań
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void increaseWaterLevel(HttpSession session) {
        //sprawdzamy czy w obiekcie sesji istnieje atrybut "water":
        // (jeżeli istnieje, to go zwróci, jeżeli nie: zwróci null)
        Object water = session.getAttribute("water");
        int resultWater;
        //sprawdzamy czy nie na nulla
        if (water == null) {
            resultWater = GLASS_OF_WATER;
        } else {
            resultWater = ((int) water) + GLASS_OF_WATER;
        }

        //tworzymy atrybut "water", do którego przypisujemy wartość resultWater
        session.setAttribute("water", resultWater);
    }

}
