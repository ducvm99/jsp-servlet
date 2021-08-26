package com.example.redirect301.filter;

import com.example.redirect301.ultis.DataUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebFilter(urlPatterns = {"/*"})
public class Redirect301Filter implements Filter {

    public Redirect301Filter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // URL gửi đến Server.
        String url = request.getRequestURL().toString();
        System.out.println("Incomming URL = " + url);

        Map<String, String> redirect301Map = DataUtils.getRedirect301Map();

        // Tìm URL mới.
        String newUrl = redirect301Map.get(url);

        if (newUrl != null) {

            // Chuyển hướng 301 (Redirect 301).
            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
            response.setHeader("Location", newUrl);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
