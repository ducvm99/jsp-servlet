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

@WebServlet(name = "UserInfoServlet", urlPatterns = { "/userInfo" })
public class UserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserInfoServlet() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();

        // Lấy ra đối tượng HttpSession
        HttpSession session = request.getSession();

        // Lấy ra đối tượng UserInfo đã được lưu vào session
        // sau khi người dùng login thành công.
        UserInfo loggedInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);

        // Chưa login, Redirect (chuyển hướng) về trang login (LoginServlet).
        if (loggedInfo == null) {
            // => /login
            response.sendRedirect(this.getServletContext().getContextPath() + "/login");
            return;
        }

        out.println("<html>");
        out.println("<head><title>Session Example</title></head>");
        out.println("<body>");
        out.println("<h3>User Info:</h3>");
        out.println("<p>User Name: " + loggedInfo.getUserName() + "</p>");
        out.println("<p>Country: " + loggedInfo.getCountry() + "</p>");
        out.println("<p>Post: " + loggedInfo.getPost() + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
