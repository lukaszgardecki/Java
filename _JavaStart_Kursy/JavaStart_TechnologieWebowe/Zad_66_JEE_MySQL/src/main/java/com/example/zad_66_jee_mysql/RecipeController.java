package com.example.zad_66_jee_mysql;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class RecipeController extends HttpServlet {
    private final RecipeDao recipeDao = new RecipeDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Recipe> allRecipes = recipeDao.findAll();
        request.setAttribute("recipes", allRecipes);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

}
