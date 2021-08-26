package com.example.tutorial.servletFilter.connection;

import com.example.tutorial.jdbc.ConnectionUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter(urlPatterns = { "/*" })
public class JDBCFilter implements Filter {
    public JDBCFilter() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String servletPath  = req.getServletPath();

        // Chỉ mở Connection (kết nối) đối với các request có đường dẫn đặc biệt
        // (Chẳng hạn đường dẫn tới các servlet, jsp, ..)
        //
        // Tránh tình trạng mở Connection với các yêu cầu thông thường
        // (Chẳng hạn image, css, javascript,... )
        //
        if (servletPath.contains("/all-students") || servletPath.contains("/specialPath2")) {
            Connection connection = null;
            try {
                System.out.println("make connection to database");
                // Tạo đối tượng Connection kết nối database.
                connection = ConnectionUtils.getConnection();
                // Set tự động commit = false, để chủ động điều khiển.
                connection.setAutoCommit(false);

                // Lưu trữ vào thuộc tính (attribute) của request.
                MyUtils.storeConnection(servletRequest, connection);

                // Cho phép request được đi tiếp (Vượt qua Filter này).
                filterChain.doFilter(servletRequest, servletResponse);

                // Gọi commit() để hoàn thành giao dịch (transaction) với DB.
                connection.commit();

            } catch (Exception e) {
                ConnectionUtils.rollbackQuietly(connection);
            } finally {
                ConnectionUtils.closeQuietly(connection);
            }
        }
        // Đối với các request thông thường.
        else {
            System.out.println("unmake connection to database");
            // Cho phép request đi tiếp (Vượt qua Filter này).
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
