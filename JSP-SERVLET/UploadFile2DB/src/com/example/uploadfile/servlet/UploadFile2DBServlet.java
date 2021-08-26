package com.example.uploadfile.servlet;

import com.example.uploadfile.conn.ConnectionUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "UploadFile2DBServlet", urlPatterns = {"/uploadToDB"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class UploadFile2DBServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;

        try {
            // Kết nối tới Database
            connection = ConnectionUtils.getConnection();
            connection.setAutoCommit(false);

            String description = request.getParameter("description");

            // Danh mục các phần đã upload lên (Có thể là nhiều file).
            for (Part part: request.getParts()) {
                String fileName = extractFileName(part);
                if (fileName != null && fileName.length() > 0) {
                    // Dữ liệu file.
                    InputStream inputStream = part.getInputStream();
                    System.out.println(inputStream);
                    // Ghi vào file.
                    this.writeToDB(connection, fileName, inputStream, description);
                }
            }

            connection.commit();

            // Upload thành công.
            response.sendRedirect(request.getContextPath() + "/uploadToDBResults");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/uploadToDB.jsp");
            dispatcher.forward(request, response);
        } finally {
            this.closeQuietly(connection);
        }
    }

    private String extractFileName(Part part) {
        // form-data; name="file"; filename="C:\file1.zip"
        // form-data; name="file"; filename="C:\Note\file2.zip"
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                // C:\file1.zip
                // C:\Note\file2.zip
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", "/");
                int i = clientFileName.lastIndexOf('/');
                // file1.zip
                // file2.zip
                return clientFileName.substring(i + 1);
            }
        }
        return null;
    }

    private void writeToDB(Connection connection, String fileName, InputStream inputStream, String description) throws SQLException {
        String sqlCommand = "insert into Attachment(Id,File_Name,File_Data,Description) values (?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(sqlCommand);

        Long id = this.getMaxAttachmentId(connection) + 1;
        statement.setLong(1, id);
        statement.setString(2, fileName);
        statement.setBlob(3, inputStream);
        statement.setString(4, description);
        statement.executeUpdate();
    }

    private long getMaxAttachmentId(Connection connection) throws SQLException {
        String sqlCommand = "select max(a.id) from Attachment a";

        PreparedStatement statement = connection.prepareStatement(sqlCommand);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            long max = resultSet.getLong(1);
            return max;
        }
        return 0L;
    }

    private void closeQuietly(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/uploadToDB.jsp");
        dispatcher.forward(request, response);
    }
}
