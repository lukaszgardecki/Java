package com.mojastrona.zad_60_jee_kalkulatoriloscifarby;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/calculate")
public class PaintCalculatorController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Room room = getRoom(request);
        PaintDetails paintDetails = getPaintDetails(request);
        int paintAmount = PaintCalculator.calculatePaintAmount(room, paintDetails);
        request.setAttribute("paintArea", room.getPaintArea() / PaintCalculator.SQM_TO_SQCM);
        request.setAttribute("paintAmount", paintAmount);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    private Room getRoom(HttpServletRequest request) {
        int roomLength = Integer.parseInt(request.getParameter("roomLength"));
        int roomWidth = Integer.parseInt(request.getParameter("roomWidth"));
        int roomHeight = Integer.parseInt(request.getParameter("roomHeight"));
        ConstructionElement[] constructionElements = getConstructionElements(request);
        return new Room(roomWidth, roomHeight, roomLength, constructionElements);
    }

    private ConstructionElement[] getConstructionElements(HttpServletRequest request) {
        int constructionElementsNo = Integer.parseInt(request.getParameter("constructionElements"));
        ConstructionElement[] elements = new ConstructionElement[constructionElementsNo];
        String[] widths = request.getParameterValues("width");
        String[] heights = request.getParameterValues("height");
        for (int i = 0; i < constructionElementsNo; i++) {
            int width = Integer.parseInt(widths[i]);
            int height = Integer.parseInt(heights[i]);
            elements[i] = new ConstructionElement(width, height);
        }
        return elements;
    }

    private PaintDetails getPaintDetails(HttpServletRequest request) {
        int paintCoverage = Integer.parseInt(request.getParameter("paintCoverage"));
        int paintCoats = Integer.parseInt(request.getParameter("paintCoats"));
        return new PaintDetails(paintCoverage, paintCoats);
    }


}
