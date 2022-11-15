package com.mojastrona.zad_53_jee_ciasteczka;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/counter")
public class CounterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //wyszukujemy ciatseczko w przglądarce użytkownika:
        Optional<Cookie> visitsCookie = getCookieByName(request, "visits");
        Integer numberOfVisits = visitsCookie
                .map(Cookie::getValue)
                .map(Integer::valueOf)
                .orElse(0);
        //zwiększamy wartość tego ciasteczka
        numberOfVisits++;

        // tworzymy nowe ciasteczko o jakiejś nazwie i wartości (wartość musi być typu String)
        Cookie cookie = new Cookie("visits", Integer.toString(numberOfVisits));

        //ustawiamy długość życia ciasteczka np. na 30 dni
        //jeśli tego nie ustawimy to ciasteczko będzie będzie ciasteczkiem sesyjnym
        // tzn. że żyje dopóki jest włączona przeglądarka
        //jest to czas życia w SEKUNDACH!
        cookie.setMaxAge(30 * 24 * 60 * 60);

        //dodajemy ciasteczko do obiektu response:
        response.addCookie(cookie);

        //możemy stworzyć dowolną liczbę ciasteczek
        //trzeba wtedy wywowałć odpowiednią ilość razy metodę addCookie

        //nie chcemy, żeby znajdowała się tutaj żadna logika, więc tworzymy nowy atrybut:
        //nazwa atrybutu - wartość atrybutu
        //ustawiamy ten atrybut żeby później go wyświetlić w szablonie .jsp
        request.setAttribute("numberOfVisits", numberOfVisits);

        //żądanie przekazujemy z wykorzystaniem dyspozytora żądań do strony visits.jsp;
        // przekazujemy żądanie wywołując metodę forward
        request.getRequestDispatcher("/visits.jsp").forward(request, response);
    }

    private Optional<Cookie> getCookieByName(HttpServletRequest request, String cookieName) {
        // pobieramy ciasteczka, istnieje tylko jedna metoda getCookies, która zwraca tablicę wszystkich ciasteczek
        Cookie[] cookies = request.getCookies();
        // metoda getCookies może zwrócić null, więc trzeba się przed tym zabezpieczyć
        if (cookies == null) {
            return Optional.empty();
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return Optional.of(cookie);
            }
        }
        return Optional.empty();
    }

}
