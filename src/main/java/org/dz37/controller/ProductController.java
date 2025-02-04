package org.dz37.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dz37.entity.Product;
import org.dz37.service.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ProductController {
    private final ProductService productService = new ProductService();
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
            Product product = objectMapper.readValue(jsonBuilder.toString(), Product.class);
            this.productService.create(product);
            response.getWriter().write("{\"status\":\"success\"}");
        } catch (NumberFormatException|NullPointerException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"status\":\"error\", \"message\":\"" + e.getMessage() + "\"}");
        }
    }

    public void show(HttpServletRequest request, HttpServletResponse response, Long id) throws ServletException, IOException {
        response.setContentType("application/json");
        try {
            Product product = this.productService.show(id);
            if (product != null) {
                String jsonResponse = objectMapper.writeValueAsString(product);
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
            Optional<List<Product>> products = this.productService.index();
            String jsonResponse = objectMapper.writeValueAsString(products.orElse(List.of()));
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
            Product product = objectMapper.readValue(jsonBuilder.toString(), Product.class);
            product.setId(id);
            this.productService.update(product);
            response.getWriter().write("{\"status\":\"updated\"}");
        } catch (NumberFormatException|NullPointerException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"status\":\"error\", \"message\":\"" + e.getMessage() + "\"}");
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response, Long id) throws ServletException, IOException {
        response.setContentType("application/json");
        Product product = this.productService.show(id);
        if(product != null) {
            this.productService.delete(id);
            response.getWriter().write("{\"status\":\"deleted\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("{\"status\":\"error\", \"message\":\"Product not found\"}");
        }
    }



}

