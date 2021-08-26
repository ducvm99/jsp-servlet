package com.example.simeplewebapp.servlet;

import com.example.simeplewebapp.beans.UserAccount;
import com.example.simeplewebapp.utils.DBUtils;
import com.example.simeplewebapp.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    // Khi người nhập userName & password, và nhấn Submit.
    // Phương thức này sẽ được thực thi.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String rememberMeStr = request.getParameter("rememberMe");
        Boolean remember = "Y".equals(rememberMeStr);

        UserAccount userAccount = null;
        boolean hasError = false;
        String errorString = null;

        if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Required username and password";
        } else {
            Connection connection = MyUtils.getStoredConnection(request);
            try {
                // Tìm user trong DB.
                userAccount = DBUtils.findUser(connection, userName, password);

                if (userAccount == null) {
                    hasError = true;
                    errorString = "username or password invalid";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        // Trong trường hợp có lỗi,
        // forward (chuyển hướng) tới /WEB-INF/views/login.jsp
        if (hasError) {
            userAccount = new UserAccount();
            userAccount.setUserName(userName);
            userAccount.setPassword(password);

            // Lưu các thông tin vào request attribute trước khi forward.
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", userAccount);

            // Forward (Chuyển tiếp) tới trang /WEB-INF/views/login.jsp
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
            dispatcher.forward(request, response);
        }
        // Trường hợp không có lỗi.
        // Lưu thông tin người dùng vào Session.
        // Và chuyển hướng sang trang userInfo.
        else {
            HttpSession session = request.getSession();
            MyUtils.storeLoggedUser(session, userAccount);

            // Nếu người dùng chọn tính năng "Remember me".
            if (remember) {
                MyUtils.storeUserCookie(response, userAccount);
            }
            // Ngược lại xóa Cookie
            else {
                MyUtils.deleteUserCookie(response);
            }

            // Redirect (Chuyển hướng) sang trang /userInfo
            response.sendRedirect(request.getContextPath() + "/userInfo");
        }
    }

    // Hiển thị trang Login.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward tới trang /WEB-INF/views/loginView.jsp
        // (Người dùng không thể truy cập trực tiếp
        // vào các trang JSP đặt trong thư mục WEB-INF).
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
        dispatcher.forward(request, response);
    }
}
