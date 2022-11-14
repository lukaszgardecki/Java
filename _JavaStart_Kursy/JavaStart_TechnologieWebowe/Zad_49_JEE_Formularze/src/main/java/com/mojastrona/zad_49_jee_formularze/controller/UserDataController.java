package com.mojastrona.zad_49_jee_formularze.controller;

import com.mojastrona.zad_49_jee_formularze.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userdata")
public class UserDataController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = createUserFromRequest(request);
        sendResponse(user, response);
    }

    private User createUserFromRequest(HttpServletRequest request) {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("pass"));
        user.setGender(request.getParameter("gender"));
        user.setHobby(request.getParameterValues("hobby"));
        return user;
    }

    private void sendResponse(User user, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Dane odebrano pomyślnie</h1>");
        writer.println("<div>");
        writer.print(user.getUsername() + "<br>    ");
        writer.print(user.getPassword() + "<br>    ");
        writer.print(user.getGender() + "<br>    ");
        writer.print("Hobby:<br>");
        for (String hobby : user.getHobby()) {
            writer.print(" " + hobby + "<br>");
        }
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
    }

}
