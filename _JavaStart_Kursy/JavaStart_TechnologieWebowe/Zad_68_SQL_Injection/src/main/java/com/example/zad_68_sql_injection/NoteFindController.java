package com.example.zad_68_sql_injection;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/note")
public class NoteFindController extends HttpServlet {
    private final NoteDao noteDao = new NoteDao();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // kontroler będzie działał poprawnie tylko wtedy, gdy w adriesie URL znajdzie się tytuł notatki. Jeżeli takiego parametru nie będzie, to wysyłamy w odpowiedzi kod 404. Jeżeli parametr jednak będzie obecny, to wyświetalmy formularz z hasłem
        if (request.getParameter("title") == null) {
            response.sendError(404);
        }
        request.getRequestDispatcher("/WEB-INF/accessform.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String noteTitle = request.getParameter("title");
        String password = request.getParameter("password");
        Optional<Note> note = noteDao.findByTitleAndPassword(noteTitle, password);
        note.ifPresent(n -> request.setAttribute("note", n));
        note.map(n -> request.getRequestDispatcher("/WEB-INF/note.jsp"))
                .orElseGet(() -> request.getRequestDispatcher("/WEB-INF/accessdenied.jsp"))
                .forward(request, response);
    }
}
