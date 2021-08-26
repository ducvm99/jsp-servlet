package com.example.tutorial.servletFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebFilter(
        urlPatterns = { "*.png", "*.jpg", "*.gif"},
        initParams = {
                @WebInitParam(name = "normalImage", value="/images/girl.jpg")
        }
)
public class ImageFilter implements Filter {
    private String normalImage;

    public ImageFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // ==> /images/girl.jpg
        normalImage = filterConfig.getInitParameter("normalImage");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        // ==> /images/path/my-image.png
        // ==> /path1/path2/image.pngs
        String servletPath = req.getServletPath();

        // Đường dẫn tuyệt đối của thư mục gốc của WebApp (WebContent).
        String realRootPath = servletRequest.getServletContext().getRealPath("");

        // Đường dẫn tuyệt đối tới file ảnh.
        String imageRealPath = realRootPath + servletPath;

        System.out.println("imageRealPath = " + imageRealPath);

        File file = new File(imageRealPath);

        // Kiểm tra xem ảnh có tồn tại không.
        if (file.exists()) {
            // Cho phép request được đi tiếp. (Vượt qua Filter này).
            // (Để đi tiếp tới file ảnh yêu cầu).
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (!servletPath.equals(this.normalImage)) {
            // Redirect (Chuyển hướng) tới file ảnh 'normalImage'.
            HttpServletResponse resp = (HttpServletResponse) servletResponse;

            // ==> /ServletFilterTutorial + /images/girl.png
//            resp.sendRedirect(req.getContextPath() + this.normalImage);
            servletRequest.getServletContext().getRequestDispatcher(this.normalImage).forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
