package se.ifmo.web.lab3.lab3.controllers;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.ifmo.web.lab3.lab3.utils.ErrorPrinter;

@WebServlet(value = "/point/send")
public class PointServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            ErrorPrinter.print(response, "e.getMessage()");
        } catch (Exception e) {
            ErrorPrinter.print(response, e.getMessage());
        }
    }
}
