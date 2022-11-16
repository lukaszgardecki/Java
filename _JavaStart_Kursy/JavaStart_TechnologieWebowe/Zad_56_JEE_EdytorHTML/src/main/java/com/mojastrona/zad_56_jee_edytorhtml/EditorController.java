package com.mojastrona.zad_56_jee_edytorhtml;

import java.io.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
/**
Scenariusz, który musimy teraz zrealizować jest taki, że jeżeli ktoś wchodzi na stronę główną (żądanie GET), to wykonujemy takie czynności:

        1. pobieramy atrybut text z kontekstu aplikacji,
        2. jeżeli atrybut nie jest nullem, to ustawiamy go jako atrybut żądania o nazwie text, a w innym przypadku ustawiamy pusty napis,
        3. przekazujemy żądanie do strony index.jsp.

        Dzięki temu, że na stronie index.jsp zapisaliśmy skryptlet <%=request.getAttribute("text")%>, to przekazany tekst zostanie wyświetlony wewnątrz edytora TinyMCE.

        Po wciśnięciu przycisku pod edytorem zostanie wysłane żądanie POST. Jego obsługa będzie wymagała takich kroków:

        1. odczytujemy parametr text z żądania,
        2. zapisujemy wartość parametru jako atrybut kontekstu aplikacji o nazwie text,
        3. ustawiamy atrybut żądania o nazwie text z taką samą wartością jak przekazano w parametrze, dzięki temu w edytorze będzie wyświetlony przesłany tekst (tak samo jak robiliśmy w metodzie doGet()),
        4. przekazujemy żądanie do strony index.jsp.
*/


@WebServlet("")
public class EditorController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext context = getServletContext();
        Object text = context.getAttribute("text");
        forwardRequestWithTextAttribute(request, response, text);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        String text = request.getParameter("text");
        context.setAttribute("text", text);
        forwardRequestWithTextAttribute(request, response, text);

    }

    private static void forwardRequestWithTextAttribute(HttpServletRequest request, HttpServletResponse response, Object text) throws ServletException, IOException {
        request.setAttribute("text", text != null ? text : "");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}