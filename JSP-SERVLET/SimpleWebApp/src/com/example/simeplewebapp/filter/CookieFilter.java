package com.example.simeplewebapp.filter;

import com.example.simeplewebapp.beans.UserAccount;
import com.example.simeplewebapp.utils.DBUtils;
import com.example.simeplewebapp.utils.MyUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookieFilter implements Filter {
    public CookieFilter() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        UserAccount userInSession = MyUtils.getLoggedUser(session);
        //
        if (userInSession != null) {
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // Connection đã được tạo trong JDBCFilter.
        Connection connection = MyUtils.getStoredConnection(servletRequest);

        // Cờ (flag) để kiểm tra Cookie.
        String checked = (String) session.getAttribute("COOKIE_CHECKED");
        if (checked == null && connection != null) {
            String userName = MyUtils.getUserNameInCookie(request);
            try {
                UserAccount userAccount = DBUtils.findUser(connection, userName);
                MyUtils.storeLoggedUser(session, userAccount);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            // Đánh dấu đã kiểm tra Cookie.
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
