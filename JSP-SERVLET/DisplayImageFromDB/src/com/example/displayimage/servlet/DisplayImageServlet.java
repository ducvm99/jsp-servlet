package com.example.displayimage.servlet;

import com.example.displayimage.conn.ConnectionUtils;
import com.example.displayimage.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "DisplayImageServlet", urlPatterns = {"/image"})
public class DisplayImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DisplayImageServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;

        try {
            // Lấy ra kết nối tới Database
            connection = ConnectionUtils.getConnection();
            Long id = null;
            try {
                id = Long.parseLong(request.getParameter("id"));
            } catch (Exception e) {

            }
            Person person = getImageInTable(connection, id);

            if (person == null) {
                // Không có dữ liệu ảnh, chuyển hướng tới một ảnh mặc định.
                response.sendRedirect(request.getContextPath() + "/images/defaultImage.jpg");
                return;
            }

            // trump.jpg, putin.png
            String imageFileName = person.getImageFileName();
            System.out.println("File Name: " + imageFileName);

            // image/jpg
            // image/png
            String contentType = this.getServletContext().getMimeType(imageFileName);
            System.out.println("Content Type" + contentType);

            response.setHeader("Content-Type", contentType);
            response.setHeader("Content-Length", String.valueOf(person.getImageData().length));
            response.setHeader("Content-Disposition", "inline; filename=\"" + person.getImageFileName() + "\"");

            // Ghi dữ liệu ảnh vào Response.
            response.getOutputStream().write(person.getImageData());

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Person getImageInTable(Connection connection, Long id) throws SQLException {
        String sqlCommand = "select p.Id, p.Name, p.Image_Data, p.Image_File_Name from Person p where p.id = ?";
        PreparedStatement statement = connection.prepareStatement(sqlCommand);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("Name");
            byte[] imageData = resultSet.getBytes("Image_Data");
            String imageFileName = resultSet.getString("Image_File_Name");
            return new Person(id, name, imageData, imageFileName);
        }
        return null;
    }
}
