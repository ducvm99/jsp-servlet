package com.example.simeplewebapp.utils;

import com.example.simeplewebapp.beans.Product;
import com.example.simeplewebapp.beans.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    public static UserAccount findUser(Connection connection, String userName, String password) throws SQLException {
        String sqlCommand = "select a.User_Name, a.Password, a.Gender from User_Account a where a.User_Name = ? and a.password = ?";

        PreparedStatement statement = connection.prepareStatement(sqlCommand);
        statement.setString(1, userName);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String gender = resultSet.getString("Gender");
            UserAccount userAccount = new UserAccount();
            userAccount.setUserName(userName);
            userAccount.setPassword(password);
            userAccount.setGender(gender);
            return userAccount;
        }
        return null;
    }

    public static UserAccount findUser(Connection connection, String userName) throws SQLException {
        String sqlCommand = "select a.User_Name, a.Password, a.Gender from User_Account a where a.User_Name = ?";

        PreparedStatement statement = connection.prepareStatement(sqlCommand);
        statement.setString(1, userName);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String password = resultSet.getString("Password");
            String gender = resultSet.getString("Gender");
            UserAccount userAccount = new UserAccount();
            userAccount.setUserName(userName);
            userAccount.setPassword(password);
            userAccount.setGender(gender);
            return userAccount;
        }
        return null;
    }

    public static List<Product> queryProduct(Connection connection) throws SQLException {
        String sqlCommand = "select a.Code, a.Name, a.Price from Product a";

        PreparedStatement statement = connection.prepareStatement(sqlCommand);

        ResultSet resultSet = statement.executeQuery();

        List<Product> list = new ArrayList<Product>();
        while (resultSet.next()) {
            String code = resultSet.getString("Code");
            String name = resultSet.getString("Name");
            float price = resultSet.getFloat("Price");
            Product product = new Product();
            product.setCode(code);
            product.setName(name);
            product.setPrice(price);
            list.add(product);
        }
        return list;
    }

    public static Product findProduct(Connection connection, String code) throws SQLException {
        String sqlCommand = "select a.Code, a.Name, a.Price from Product a where a.Code = ?";

        PreparedStatement statement = connection.prepareStatement(sqlCommand);
        statement.setString(1, code);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("Name");
            float price = resultSet.getFloat("price");
            Product product = new Product(code, name, price);
            return product;
        }
        return null;
    }

    public static void updateProduct(Connection connection, Product product) throws SQLException {
        String sqlCommand = "update Product set Name = ?, Price = ? where code = ?";

        PreparedStatement statement = connection.prepareStatement(sqlCommand);
        statement.setString(1, product.getName());
        statement.setFloat(2, product.getPrice());
        statement.setString(3, product.getCode());
        statement.executeUpdate();
    }

    public static void insertProduct(Connection connection, Product product) throws SQLException {
        String sqlCommand = "insert into Product(Code, Name, Price) values (?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sqlCommand);
        statement.setString(1, product.getCode());
        statement.setString(2, product.getName());
        statement.setFloat(3, product.getPrice());

        statement.executeUpdate();
    }

    public static void deleteProduct(Connection connection, String code) throws SQLException {
        String sqlCommand = "delete from Product where Code = ?";

        PreparedStatement statement = connection.prepareStatement(sqlCommand);

        statement.setString(1, code);

        statement.executeUpdate();
    }
}
