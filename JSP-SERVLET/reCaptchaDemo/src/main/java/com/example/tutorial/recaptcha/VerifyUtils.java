package com.example.tutorial.recaptcha;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class VerifyUtils {
    public static final String SITE_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

    public static boolean verify(String gRecaptchaResponse) {
        if (gRecaptchaResponse == null || gRecaptchaResponse.length() == 0) {
            return false;
        }

        try {
            URL verifyUrl = new URL(SITE_VERIFY_URL);

            // Mở một kết nối (Connection) tới URL trên.
            HttpsURLConnection connection = (HttpsURLConnection) verifyUrl.openConnection();

            // Thêm các thông tin Header vào Request chuẩn bị gửi tới server.
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            // Dữ liệu sẽ gửi tới Server.
            String postParams = "secret=" + MyConstants.SECRET_KEY + "&response=" +gRecaptchaResponse;

            // Send Request
            connection.setDoOutput(true);

            // Lấy Output Stream (Luồng đầu ra) của kết nối tới Server.
            // Ghi dữ liệu vào Output Stream, có nghĩa là gửi thông tin đến Server.
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(postParams.getBytes());

            outputStream.flush();
            outputStream.close();

            // Mã trả lời được trả về từ Server.
            int responseCode = connection.getResponseCode();
            System.out.println("responseCode=" + responseCode);

            // Lấy Input Stream (Luồng đầu vào) của Connection
            // để đọc dữ liệu gửi đến từ Server.
            InputStream inputStream = connection.getInputStream();

            JsonReader jsonReader = Json.createReader(inputStream);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();

            // ==> {"success": true}
            System.out.println("Response: " + jsonObject);

            boolean success = jsonObject.getBoolean("success");
            return success;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
