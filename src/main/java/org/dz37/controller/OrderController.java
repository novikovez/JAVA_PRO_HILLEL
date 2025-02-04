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
import java.util.List;
import java.util.Optional;

@WebServlet("/orders") // <-- Роут
public class OrderController extends HttpServlet {
    private final OrderService orderService = new OrderService();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final StringBuilder jsonBuilder = new StringBuilder();

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try {
            String line;
            try (BufferedReader reader = request.getReader()) {
                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
            } catch (IOException e) {
                throw new ServletException("Error reading request body", e);
            }
            Order order = objectMapper.readValue(jsonBuilder.toString(), Order.class);
            this.orderService.create(order);
            response.getWriter().write("{\"status\":\"success\"}");
        } catch (NumberFormatException|NullPointerException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"status\":\"error\", \"message\":\"" + e.getMessage() + "\"}");
        }
    }

    public void show(HttpServletRequest request, HttpServletResponse response, Long id) throws ServletException, IOException {
        response.setContentType("application/json");
        try {
            Order order = this.orderService.show(id);
            if (order != null) {
                String jsonResponse = objectMapper.writeValueAsString(order);
                response.getWriter().write(jsonResponse);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{\"status\":\"error\", \"message\":\"Product not found\"}");
            }
        } catch (NumberFormatException|NullPointerException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"status\":\"error\", \"message\":\"" + e.getMessage() + "\"}");
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Optional<List<Order>> orders = this.orderService.index();
            String jsonResponse = objectMapper.writeValueAsString(orders.orElse(List.of()));
            response.getWriter().write(jsonResponse);
        } catch (NumberFormatException|NullPointerException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"status\":\"error\", \"message\":\"" + e.getMessage() + "\"}");
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response, Long id) throws ServletException, IOException {
        response.setContentType("application/json");
        try {
            String line;
            try (BufferedReader reader = request.getReader()) {
                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
            } catch (IOException e) {
                throw new ServletException("Error reading request body", e);
            }
            Order order = objectMapper.readValue(jsonBuilder.toString(), Order.class);
            order.setId(id);
            this.orderService.update(order);
            response.getWriter().write("{\"status\":\"updated\"}");
        } catch (NumberFormatException|NullPointerException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"status\":\"error\", \"message\":\"" + e.getMessage() + "\"}");
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response, Long id) throws ServletException, IOException {
        response.setContentType("application/json");
        Order order = this.orderService.show(id);
        if(order != null) {
            this.orderService.delete(id);
            response.getWriter().write("{\"status\":\"deleted\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("{\"status\":\"error\", \"message\":\"Product not found\"}");
        }
    }



//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("application/json");
//        try {
//            StringBuilder jsonBuilder = new StringBuilder();
//            String line;
//            try (BufferedReader reader = request.getReader()) {
//                while ((line = reader.readLine()) != null) {
//                    jsonBuilder.append(line);
//                }
//            } catch (IOException e) {
//                throw new ServletException("Error reading request body", e);
//            }
//            ObjectMapper objectMapper = new ObjectMapper();
//            Order order = objectMapper.readValue(jsonBuilder.toString(), Order.class);
//            this.orderService.create(order);
//            response.getWriter().write("{\"status\":\"success\"}");
//        } catch (NumberFormatException|NullPointerException e) {
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            response.getWriter().write("{\"status\":\"error\", \"message\":\"" + e.getMessage() + "\"}");
//
//        }
//    }
}

