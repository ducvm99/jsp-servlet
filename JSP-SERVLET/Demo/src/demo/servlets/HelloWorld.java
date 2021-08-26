package demo.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorld")
public class HelloWorld extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loadParameter(request, response, "by Post");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loadParameter(request, response, "by Get");
    }

    private void loadParameter(HttpServletRequest request, HttpServletResponse response, String method) throws IOException {
        ServletContext context = this.getServletContext();
        this.getServletConfig().getServletContext();

        String account = context.getInitParameter("account");
        String password = context.getInitParameter("password");

        ServletConfig config = this.getServletConfig();
        String song = config.getInitParameter("song");
        PrintWriter writer = response.getWriter();
        writer.println("Hello World " + method + "</br>");
        writer.println("The song is: " + song);

        writer.println("The account is: " + account);
        writer.println("The password is: " + password);
    }
}
