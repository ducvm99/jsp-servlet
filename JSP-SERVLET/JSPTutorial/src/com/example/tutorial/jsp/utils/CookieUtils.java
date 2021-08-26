package com.example.tutorial.jsp.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CookieUtils {
    public static void demoUserCookie(HttpServletRequest request, HttpServletResponse response, JspWriter out) throws IOException {
        boolean found = false;

        // Danh sách các cookies được website này lưu vào máy tính người dùng.
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            String userName = null;
            String lastLoginDatetime = null;
            out.println("<h3>Cookies:</h3>");

            for (Cookie cookie : cookies) {
                out.println(cookie.getName() + " : " + cookie.getValue() + "<br>");
                if (cookie.getName().equals("userName")) {
                    userName = cookie.getValue();
                } else if (cookie.getName().equals("lastLoginDatetime")) {
                    {
                        lastLoginDatetime = cookie.getValue();
                    }
                }
            }
            if (userName != null) {
                found = true;
                out.println("<h4>Last login info:</h4>");
                out.println("User Name: " + userName + "<br>");
                out.println("Last Login Datetime: " + lastLoginDatetime + "<br>");
            }
        }

        if (!found) {
            out.println("<h3>No cookies founds!, write some cookies into client computer</h3>");
            // Ghi một vài thông tin Cookie vào máy tính người dùng.
            // Chẳng hạn như userName họ đã từng login.
            // Đây là cách nhớ user đã login
            // Mô phỏng ghi Cookie vào máy tính người dùng sau khi họ vừa login.

            String userName = "someUserName";

            Cookie cookieUserName = new Cookie("userName", userName);

            DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date now = new Date();

            String lastLoginDatetime = df.format(now);

            Cookie cookieLoginDatetime = new Cookie("lastLoginDatetime", lastLoginDatetime.replace(" ", "-"));

            // Sét đặt thời gian sống của Cookie là 24h (Đã đổi ra giây).
            cookieUserName.setMaxAge(24 * 60 * 60);
            // Sét đặt thời gian sống của Cookie là 24h (Đã đổi ra giây).
            cookieLoginDatetime.setMaxAge(24 * 60 * 60);

            // Ghi vào máy tính người dùng.
            response.addCookie(cookieUserName);
            // Ghi vào máy tính người dùng.
            response.addCookie(cookieLoginDatetime);
        }
    }
}
