package com.mojastrona.projekt_readstack.client.home;

import com.mojastrona.projekt_readstack.domain.api.DiscoveryBasicInfo;
import com.mojastrona.projekt_readstack.domain.api.DiscoveryService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    private DiscoveryService discoveryService = new DiscoveryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DiscoveryBasicInfo> discoveries = discoveryService.findAll();
        request.setAttribute("discoveries", discoveries);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
