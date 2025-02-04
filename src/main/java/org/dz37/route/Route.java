package org.dz37.route;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dz37.controller.OrderController;
import org.dz37.controller.ProductController;

import java.io.IOException;

@WebServlet("/api/*")
public class Route extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    public void handler(String route, Long id, String method) {
        try {
            switch (route) {
                case "GET/product/show" -> new ProductController().show(request, response, id);
                case "GET/product/list" -> new ProductController().index(request, response);
                case "POST/product/create" -> new ProductController().create(request, response);
                case "PUT/product/update" -> new ProductController().update(request, response, id);
                case "DELETE/product/delete" -> new ProductController().delete(request, response, id);
                case "GET/order/show" -> new OrderController().show(request, response, id);
                case "GET/order/list" -> new OrderController().index(request, response);
                case "POST/order/create" -> new OrderController().create(request, response);
                case "PUT/order/update" -> new OrderController().update(request, response, id);
                case "DELETE/order/delete" -> new OrderController().delete(request, response, id);
                default -> throw new ServletException("Invalid route: " + route);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        this.route(request, response, "GET");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        this.route(request, response, "POST");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        this.route(request, response, "PUT");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        this.route(request, response, "DELETE");
    }


    private void route(HttpServletRequest request, HttpServletResponse response, String method) {
        this.request = request;
        this.response = response;
        String path = request.getPathInfo();
        long id = 0L;
        String routePath = "/";
        if (path != null) {
            String[] pathParts = path.split("/");
            if(checkInt(pathParts)) {
                id =  Long.parseLong(pathParts[3]);
            }
            routePath = method + '/' + pathParts[1] + '/' + pathParts[2];
        }
        handler(routePath, id, method);
    }

    private boolean checkInt(String[] pathParts) {
        if(pathParts.length > 3) {
            try {
                Long.parseLong(pathParts[3]);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }


}
