package com.example.zad_67_ksiegagosci;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("")
public class VisitController extends HttpServlet {
    private VisitDao visitDao = new VisitDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Visit> allVisits = visitDao.findAll();
        request.setAttribute("visits", allVisits);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String author = request.getParameter("author");
        String text = request.getParameter("text");
        visitDao.add(new Visit(author, text));
        response.sendRedirect(request.getContextPath());
    }
}
