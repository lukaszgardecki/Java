package com.mojastrona.zad_58_jee_expressionlanguage;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("")
public class PersonController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("people", new ArrayList<Person>());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        Gender gender = Gender.valueOf(request.getParameter("gender"));
        Person person = new Person(firstName, lastName, age, gender);
        List<Person> peopleList = (List<Person>) getServletContext().getAttribute("people");
        peopleList.add(person);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
