package demo.servlets;

import demo.models.DatabaseManagement;
import demo.models.Image;
import sun.misc.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Authentication extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        PrintWriter writer = response.getWriter();

        DatabaseManagement dm = new DatabaseManagement();
        if (dm.checkUser(username, password)) {
//            Cookie cookie = new Cookie("location", "Vietnam");
            response.addCookie(new Cookie("location", "Vietnam"));
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
//            session.setMaxInactiveInterval(900);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/ImageShow");

            Image image = new Image("Girl", 200, 300);

            request.setAttribute("imageName", image);

            session.setAttribute("test", new Image("Testing image", 200, 300));
            session.removeAttribute("test");

            dispatcher.forward(request, response);
//            writer.println("Welcome " + username + " to the Website");
        }
        else {
            response.sendRedirect("login.jsp");
        }
    }
}
