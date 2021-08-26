package demo.servlets;

import demo.models.Image;
import demo.models.Student;
import sun.misc.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ImageShow", urlPatterns = { "/ImageShow" })
public class ImageShow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doCheck(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doCheck(request, response);
    }

    protected void doCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
//        session.invalidate();

        if (username == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
        else {
            for (Cookie c: request.getCookies()) {
                System.out.println(c.getName());
                System.out.println(c.getValue());
            };

            // Application scope
            this.getServletContext().setAttribute("otherScope", "Application Scope");
            // Session scope
            session.setAttribute("otherScope", "Session Scope");
            // Request scope
            request.setAttribute("otherScope", "Request Scope");

            Student student = new Student();
            student.setName("Ha Linh");
//            request.setAttribute("student", student);
            List<String> languages = new ArrayList<String>();
            languages.add("java");
            languages.add("php");
            languages.add("js");
            request.setAttribute("languages", languages);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/naked.jsp");
            dispatcher.forward(request, response);
        }
    }
}
