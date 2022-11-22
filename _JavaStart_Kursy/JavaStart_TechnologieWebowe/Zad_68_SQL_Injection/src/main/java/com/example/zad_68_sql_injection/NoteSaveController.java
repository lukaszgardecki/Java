package com.example.zad_68_sql_injection;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/save")
public class NoteSaveController extends HttpServlet {
    private final NoteDao noteDao = new NoteDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Na podstawie parametrów tworzymy notatkę
        Note note = getNoteFromParameters(request);
        //Zapisujemy ją w bazie danych
        noteDao.save(note);
        //Tworzymy atrybut z notatką pod nazwą "note":
        request.setAttribute("note", note);
        //Przekazujemy żądanie do strony confirm.jsp:
        request.getRequestDispatcher("/WEB-INF/confirm.jsp").forward(request, response);
    }

    private Note getNoteFromParameters(HttpServletRequest request) {
        String title = request.getParameter("title");
        String password = request.getParameter("password");
        String content = request.getParameter("content");
        return new Note(title, content, password);
    }
}
