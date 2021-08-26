package minhduc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "HelloWorld", description = "This is a demo", urlPatterns = { "/hello" })
public class HelloWorld extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loadParameter(request, response, "by Get");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loadParameter(request, response, "by Post");
    }

    private void loadParameter(HttpServletRequest request, HttpServletResponse response, String method) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");



        PrintWriter writer = response.getWriter();
        writer.println("Hello World " + method + "</br>");
        writer.println("Hello World </br>");
        writer.println("Username: " + username + " has password: " + password);
    }
}
