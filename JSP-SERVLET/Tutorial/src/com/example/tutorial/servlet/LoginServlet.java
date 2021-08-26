package com.example.tutorial.servlet;

import com.example.tutorial.beans.Constants;
import com.example.tutorial.beans.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();

        // Lấy ra đối tượng HttpSession
        HttpSession session = request.getSession();

        // Giả sử người dùng đã login thành công.
        UserInfo loggedInfo = new UserInfo("Minh Duc", 5, "USA");

        // Lưu trữ thông tin người dùng vào 1 thuộc tính (attribute) của Session.
        session.setAttribute(Constants.SESSION_USER_KEY, loggedInfo);

        out.println("<html>");
        out.println("<head><title>Session example</title></head>");

        out.println("<body>");
        out.println("<h3>You are logined!, info stored in session</h3>");

        out.println("<a href='userInfo'>View User Info</a>");
        out.println("</body>");
        out.println("<html>");
    }
}
