package com.example.zad_69_basicauthentication_calculator.home;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.security.Principal;

@WebServlet("")
@ServletSecurity(
        @HttpConstraint(rolesAllowed = {"user_role", "admin_role"})
)
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Principal userPrincipal = request.getUserPrincipal();
        System.out.println(userPrincipal.getName());
        System.out.println(request.isUserInRole("user_role"));
        System.out.println(request.isUserInRole("admin_role"));
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

}
