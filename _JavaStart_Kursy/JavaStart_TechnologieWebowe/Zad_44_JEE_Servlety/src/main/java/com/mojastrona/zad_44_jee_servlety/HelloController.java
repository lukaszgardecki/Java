package com.mojastrona.zad_44_jee_servlety;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/hello")
public class HelloController extends HttpServlet {

    public HelloController() {
        System.out.println("Konstroler");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Metoda init");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Metoda doGet");
    }

    @Override
    public void destroy() {
        System.out.println("Metoda destroy");
    }
}
