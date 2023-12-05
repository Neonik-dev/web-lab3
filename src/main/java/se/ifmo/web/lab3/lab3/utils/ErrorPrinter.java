package se.ifmo.web.lab3.lab3.utils;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class ErrorPrinter {
    public static void print(HttpServletResponse response, String errorMessage) {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.setStatus(400);
        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.print(
                    new HashMap<>() {{
                        put("error", errorMessage);
                    }}
            );
            printWriter.flush();
        } catch (IOException e) {

        }
    }
}
