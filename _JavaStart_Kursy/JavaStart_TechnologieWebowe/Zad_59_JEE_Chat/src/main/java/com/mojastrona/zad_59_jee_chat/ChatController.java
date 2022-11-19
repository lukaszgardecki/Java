package com.mojastrona.zad_59_jee_chat;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("")
public class ChatController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Message message = createMessage(request);
        saveMessageInHistory(message, request);
        response.sendRedirect(request.getContextPath());
    }

    private void saveMessageInHistory(Message message, HttpServletRequest request) {
        ServletContext context = getServletContext();
        List<Message> messageHistory = (List<Message>) context.getAttribute("messageHistory");
        if (messageHistory == null) {
            messageHistory = new ArrayList<>();
        }
        messageHistory.add(message);
        context.setAttribute("messageHistory", messageHistory);
    }

    private Message createMessage(HttpServletRequest request) {
        String author = request.getParameter("author");
        String text = request.getParameter("message");
        return new Message(author, text);
    }
}
