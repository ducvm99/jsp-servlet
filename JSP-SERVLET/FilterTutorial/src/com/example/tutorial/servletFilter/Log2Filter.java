package com.example.tutorial.servletFilter;

import javax.servlet.*;
import java.io.IOException;

public class Log2Filter implements Filter {
    private String logFile;

    public Log2Filter() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.logFile = filterConfig.getInitParameter("logFile");

        System.out.println("Log File " + logFile);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (this.logFile != null) {
            // Ghi thông tin Log vào File.
            this.logToFile(logFile);
        }

        // Cho phép request được đi tiếp. (Vượt qua Filter này).
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void logToFile(String fileName) {
        // Ghi log vào file..
        System.out.println("Write log to file " + fileName);
    }

    @Override
    public void destroy() {
        System.out.println("Log2Filter destroy");
    }
}
