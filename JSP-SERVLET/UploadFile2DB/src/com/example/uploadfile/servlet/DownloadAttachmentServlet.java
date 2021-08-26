package com.example.uploadfile.servlet;

import com.example.uploadfile.conn.ConnectionUtils;
import com.example.uploadfile.model.Attachment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

@WebServlet(name = "DownloadAttachmentServlet", urlPatterns = {"/downloadAttachment"})
public class DownloadAttachmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;

        try {
            // Lấy ra kết nối tới Database.
            connection = ConnectionUtils.getConnection();
            Long id = null;

            try {
                id = Long.parseLong(request.getParameter("id"));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            Attachment attachment = getAttachmentFromDB(connection, id);

            if (attachment == null) {
                // Không có dữ file
                response.getWriter().write("No data found");
                return;
            }

            // file1.zip, file2.zip
            String fileName = attachment.getFile_name();
            System.out.println("File Name: " + fileName);

            // abc.txt => text/plain
            // abc.zip => application/zip
            // abc.pdf => application/pdf
            String contentType = this.getServletContext().getMimeType(fileName);
            System.out.println("Content type: " + contentType);

            response.setHeader("Content-type", contentType);

            response.setHeader("Content-length", String.valueOf(attachment.getFile_data().length()));

            response.setHeader("Content-Disposition", "inline; filename=\"" + attachment.getFile_name() + "\"");

            // Với các file attachment dung lượng lớn
            // nên đọc và ghi lần lượt
            Blob fileData = attachment.getFile_data();
            InputStream inputStream = fileData.getBinaryStream();

            byte[] bytes = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(bytes)) != -1) {
                // Ghi dữ liệu ảnh vào Response.
                response.getOutputStream().write(bytes, 0, bytesRead);
            }
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        } finally {
            this.closeQuietly(connection);
        }
    }

    private Attachment getAttachmentFromDB(Connection connection, long id) throws SQLException {
        String sqlCommand = "select a.Id, a.File_Name, a.File_Data, a.Description from Attachment a where a.id = ?";
        PreparedStatement statement = connection.prepareStatement(sqlCommand);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String fileName = resultSet.getString("File_Name");
            Blob fileData = resultSet.getBlob("File_Data");
            String description = resultSet.getString("Description");
            return new Attachment(id, fileName, fileData, description);
        }
        return null;
    }

    private void closeQuietly(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }
    }
}
