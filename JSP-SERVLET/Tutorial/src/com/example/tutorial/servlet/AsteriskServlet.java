package com.example.tutorial.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AsteriskServlet", urlPatterns = { "/any/*" })
public class AsteriskServlet extends HttpServlet {
    private static long serialVersionUID = 1L;

    public AsteriskServlet() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();

        out.println("<html>");
        out.println("<head><title>Asterisk</title></head>");

        out.println("<body>");

        out.println("<h3>Hi, your URL match /any/*</h3>");

        out.println("</body>");
        out.println("<html>");
    }
}
