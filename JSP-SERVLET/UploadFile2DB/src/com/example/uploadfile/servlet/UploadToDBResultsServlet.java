package com.example.uploadfile.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UploadToDBResultsServlet", urlPatterns = {"/uploadToDBResults"})
public class UploadToDBResultsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UploadToDBResultsServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/uploadToDBResults.jsp");
        dispatcher.forward(request, response);
    }
}
