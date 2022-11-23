package com.mojastrona.projekt_readstack.client.home;

import com.mojastrona.projekt_readstack.domain.api.CategoryName;
import com.mojastrona.projekt_readstack.domain.api.CategoryService;
import com.mojastrona.projekt_readstack.domain.api.DiscoveryBasicInfo;
import com.mojastrona.projekt_readstack.domain.api.DiscoveryService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    private final DiscoveryService discoveryService = new DiscoveryService();
    private final CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DiscoveryBasicInfo> discoveries = discoveryService.findAll();
        request.setAttribute("discoveries", discoveries);

        List<CategoryName> categories = categoryService.findAllCategoryNames();
        request.setAttribute("categories", categories);

        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }
}
