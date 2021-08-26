package com.example.tutorial.servlet;

import com.example.tutorial.beans.Constants;
import sun.misc.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowMeServlet", urlPatterns = { "/showMe" })
public class ShowMeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = (String) request.getAttribute(Constants.ATTRIBUTE_USER_NAME_KEY);
//
//        PrintWriter writer = response.getWriter();
//        writer.println(username);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/showMe.jsp");
        dispatcher.forward(request, response);
    }
}
