package com.example.cart.util;

import com.example.cart.conn.ConnectionUtils;
import com.example.cart.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    public static List<Product> getAll()
    {
        List<Product> list = new ArrayList<>();
        try {
            Connection connection = ConnectionUtils.getConnection();

            String sqlCommand = "select * from product";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setCode(resultSet.getString("code"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
