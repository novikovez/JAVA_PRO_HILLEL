package org.dz37.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dz37.entity.Order;
import org.dz37.service.OrderService;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/orders") // <-- Роут
public class OrderController extends HttpServlet {
    private final OrderService orderService = new OrderService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            try (BufferedReader reader = request.getReader()) {
                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
            } catch (IOException e) {
                throw new ServletException("Error reading request body", e);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            Order order = objectMapper.readValue(jsonBuilder.toString(), Order.class);
            this.orderService.create(order);
            response.getWriter().write("{\"status\":\"success\"}");
        } catch (NumberFormatException|NullPointerException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"status\":\"error\", \"message\":\"" + e.getMessage() + "\"}");

        }
    }
}

