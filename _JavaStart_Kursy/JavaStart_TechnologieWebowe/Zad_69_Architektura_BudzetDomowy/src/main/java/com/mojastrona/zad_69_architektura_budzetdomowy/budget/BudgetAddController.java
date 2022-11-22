package com.mojastrona.zad_69_architektura_budzetdomowy.budget;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/add")
public class BudgetAddController extends HttpServlet {
    private BudgetService budgetService = new BudgetService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/addform.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        BigDecimal value = new BigDecimal(request.getParameter("value"));
        BudgetItemType type = BudgetItemType.valueOf(request.getParameter("type"));
        BudgetItemDto budgetItem = new BudgetItemDto(description, value);

        if (type == BudgetItemType.EXPENSE) {
            budgetService.addExpense(budgetItem);
        } else if (type == BudgetItemType.INCOME) {
            budgetService.addIncome(budgetItem);
        }
        response.sendRedirect(request.getContextPath() + "/");
    }
}
