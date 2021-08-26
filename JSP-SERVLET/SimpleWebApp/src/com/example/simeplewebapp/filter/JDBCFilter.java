package com.example.simeplewebapp.filter;

import com.example.simeplewebapp.conn.ConnectionUtils;
import com.example.simeplewebapp.utils.MyUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

@WebFilter(filterName = "jdbcFilter", urlPatterns = { "/*" })
public class JDBCFilter implements Filter {
    public JDBCFilter() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    // Kiểm tra mục tiêu của request hiện tại là 1 Servlet?
    private boolean needJDBC(HttpServletRequest request) {
        System.out.println("JDBC Filter");
        //
        // Servlet Url-pattern: /spath/*
        //
        // => /spath
        String servletPath = request.getServletPath();
        // => /abc/mnp
        String pathInfo = request.getPathInfo();

        String urlPattern = servletPath;

        if (pathInfo != null) {
            // => /path/*
            urlPattern = servletPath + "/*";
        }

        // Key: servletName.
        // Value: ServletRegistration
        Map<String, ? extends ServletRegistration> servletRegistration = request.getServletContext().getServletRegistrations();

        // Tập hợp tất cả các Servlet trong WebApp của bạn.
        Collection<? extends ServletRegistration> values = servletRegistration.values();
        for (ServletRegistration sr: values) {
            Collection<String> mappings = sr.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // Chỉ mở connection (kết nối) đối với các request có đường dẫn đặc biệt.
        // (Chẳng hạn đường dẫn tới các servlet, jsp, ..)
        //
        // Tránh tình trạng mở Connection với các yêu cầu thông thường.
        // (Chẳng hạn image, css, javascript,... )
        //
        if (this.needJDBC(request)) {
            System.out.println("Open Connection for: " + request.getServletPath());

            Connection connection = null;

            try {
                // Tạo đối tượng Connection kết nối database.
                connection = ConnectionUtils.getConnection();
                // Sét tự động commit false, để chủ động điều khiển.
                connection.setAutoCommit(false);

                // Lưu trữ đối tượng Connection vào attribute của request.
                MyUtils.storeConnection(request, connection);

                // Cho phép request đi tiếp.
                // (Đi tới Filter tiếp theo hoặc đi tới mục tiêu).
                filterChain.doFilter(servletRequest, servletResponse);

                // Gọi phương thức commit() để hoàn thành giao dịch với DB.
                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
                ConnectionUtils.rollbackQuietly(connection);
                throw new ServletException();
            } finally {
                ConnectionUtils.closeQuietly(connection);
            }
        }
        // Với các request thông thường (image,css,html,..)
        // không cần mở connection.
        else {
            // Cho phép request đi tiếp.
            // (Đi tới Filter tiếp theo hoặc đi tới mục tiêu).
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
