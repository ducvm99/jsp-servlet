package com.example.tutorial.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RedirectDemoServlet", urlPatterns = { "/other/redirectDemo" })
public class RedirectDemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    // Request:
    // http://localhost:8080/ServletTutorial/other/redirectDemo?redirect=true
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy ra giá trị của tham số (parameter) trên URL.
        String redirect = request.getParameter("redirect");

        if ("true".equals(redirect)) {
            System.out.println("Redirect to ShowMeServlet");

            // contextPath: Là một String rỗng "" hoặc khác rỗng.
            // Nếu khác rỗng, nó luôn bắt đầu bởi /
            // và không kết thúc bởi /
            String contextPath = request.getContextPath();

            // => /showMe
            response.sendRedirect(contextPath + "/showMe");
            return;
        }
        ServletOutputStream out = response.getOutputStream();
        out.println("<h3>Text of RedirectDemoServlet</h3>");
        out.println("- servletPath=" + request.getServletPath());
    }
}
