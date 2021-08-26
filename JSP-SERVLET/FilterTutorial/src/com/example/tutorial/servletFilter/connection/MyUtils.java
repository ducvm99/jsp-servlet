package com.example.tutorial.servletFilter.connection;

import javax.servlet.ServletRequest;
import java.sql.Connection;

public class MyUtils {
    public static final String ATTRIBUTE_NAME = "MY_CONNECTION_ATTRIBUTE";

    // Lưu trữ đối tượng Connection vào một thuộc tính (attribute) của request.
    // Thông tin lưu trữ chỉ tồn tại trong thời gian yêu cầu (request)
    // cho tới khi dữ liệu được trả về trình duyệt người dùng.
    public static void storeConnection(ServletRequest request, Connection connection) {
        request.setAttribute(ATTRIBUTE_NAME, connection);
    }

    // Lấy đối tượng Connection đã được lưu trữ trong 1 thuộc tính của request.
    public static Connection getStoredConnection(ServletRequest request) {
        return (Connection) request.getAttribute(ATTRIBUTE_NAME);
    }
}
