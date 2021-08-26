package com.example.redirect301.ultis;

import java.util.HashMap;
import java.util.Map;

public class DataUtils {
    // URL cũ - URL mới.
    private static Map<String, String> redirect301Map;

    public static Map<String, String> getRedirect301Map() {
        if (redirect301Map == null) {
            redirect301Map = new HashMap<String, String>();

            redirect301Map.put("http://localhost:8080/Redirect301/document/123/java-servlet",
                    "http://localhost:8080/Redirect301/article/123/java-servlet-tutorial");

            redirect301Map.put("http://localhost:8080/Redirect301/document/111/java-io-tutorial",
                    "http://localhost:8080/Redirect301/article/111/java-io-tutorial");
        }
        return redirect301Map;
    }
}
