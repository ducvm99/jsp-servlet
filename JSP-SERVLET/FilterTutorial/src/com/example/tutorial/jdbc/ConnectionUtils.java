package com.example.tutorial.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.mysql.jdbc.Driver;

public class ConnectionUtils {
    static String url = "jdbc:mysql://localhost/java_jdbc";
    static String user = "root";
    static String password ="";
    static Connection connection;

    public static Connection getConnection() {
        Properties p = new Properties();
        try {
//            p.load(new FileInputStream("database.properties"));
//            url = p.getProperty("url");
//            user = p.getProperty("user");
//            password = p.getProperty("password");

            // MySql
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeQuietly(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollbackQuietly(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
