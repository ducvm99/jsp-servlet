package com.example.cart.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
    public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
        // Chú ý: Thay đổi các thông số kết nối cho phù hợp.
        String hostName = "localhost";
        String dbName = "java_cart";
        String userName = "root";
        String password = "";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        // Cấu trúc URL Connection đối với MySQL:
        // Ví dụ:
        // jdbc:mysql://localhost:3306/simplehr
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection connection = DriverManager.getConnection(connectionURL, userName, password);
        return connection;
    }
}
