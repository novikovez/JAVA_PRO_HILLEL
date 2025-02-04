package org.dz37.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dz37.dto.Order
import java.io.IOException;

@WebServlet("/order") // <-- Роут
public class Order extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        org.dz37.dto.Order order = new org.dz37.dto.Order();


        // Логика сохранения данных (например, в базу данных)
//        System.out.println("Сохранено: " + name + ", " + email);

        response.setContentType("application/json");
        response.getWriter().write("{\"status\":\"success\"}");
    }
}

