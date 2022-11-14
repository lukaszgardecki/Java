package com.mojastrona.zad_50_jee_silahasla;

import java.io.*;

import com.mojastrona.zad_50_jee_silahasla.model.Password;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/verify")
public class PasswordStrengthController extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Password password = createPassword(request);
        sendResponse(password, response);
    }

    private Password createPassword(HttpServletRequest request) {
        Password password = new Password();
        password.set(request.getParameter("pass"));
        return password;
    }

    private static void sendResponse(Password password, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html");
        writer.println("<html>");
        writer.println("<body>");
        writer.printf("<h1>Twoje hasło to: %s</h1>", password.get());
        writer.println("<ul>");
        if (password.isOK()) {
             writer.println("Hasło spełnia wszystkie kryteria bezpieczeństwa.");
        } else {
            if (!password.hasMinimum1CapitalLetter()) {
                writer.println("<li>Hasło powinno zawierać co najmniej jedną wielką literę.</li>");
            }
            if (!password.hasMinimum1SmallLetter()) {
                writer.println("<li>Hasło powinno zawierać co najmniej jedną małą literę.</li>");
            }
            if (!password.hasMinimum1Digit()) {
                writer.println("<li>Hasło powinno zawierać co najmniej jedną cyfrę.</li>");
            }
            if (!password.hasMinimum5Signs()) {
                writer.println("<li>Hasło powinno mieć minimalną długość 5 znaków.</li>");
            }
        }
        writer.println("</ul>");
        writer.println("</body>");
        writer.println("</html>");
    }
}