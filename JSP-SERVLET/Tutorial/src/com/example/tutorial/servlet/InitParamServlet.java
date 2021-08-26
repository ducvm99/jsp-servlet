package com.example.tutorial.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InitParamServlet")
public class InitParamServlet extends HttpServlet {
    private String emailSupport1;

    public InitParamServlet() {
    }

    // Phương thức này luôn luôn được gọi 1 lần
    // ngay sau khi đối tượng Servlet được tạo ra.
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // Lấy ra giá trị của tham số khởi tạo (initialization parameter) của Servlet.
        // (Theo Cấu hình của Servlet này trong web.xml).
        this.emailSupport1 = config.getInitParameter("emailSupport1");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();

        // Lấy ra giá trị của tham số khởi tạo (initialization parameter) theo một cách
        // khác.
        String emailSupport2 = this.getServletConfig().getInitParameter("emailSupport2");

        out.println("<html>");
        out.println("<head><title>Hello Servlet</title></head>");

        out.println("<body>");
//        out.println("<h3>Hello World</h3>");
//        out.println("This is my first Servlet");
        out.println("<h3>Init Param</h3>");
        out.println("<p>emailSupport1 = " + this.emailSupport1 + "</p>");
        out.println("<p>emailSupport2 = " + emailSupport2 + "</p>");
        out.println("</body>");
        out.println("<html>");
    }
}
