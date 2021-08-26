package com.example.securitywebapp.config;

import java.util.*;

public class SecurityConfig {
    public static final String ROLE_MANAGER = "MANAGER";
    public static final String ROLE_EMPLOYEE = "ROLE_EMPLOYEE";

    // String: Role
    // List<String>: urlPatterns
    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

    static {
        init();
    }

    private static void init() {
        // Cấu hình cho vai trò "EMPLOYEE".
        List<String> urlPattern1 = new ArrayList<String>();

        urlPattern1.add("/userInfo");
        urlPattern1.add("/employeeTask");

        mapConfig.put(ROLE_EMPLOYEE, urlPattern1);

        // Cấu hình cho vai trò "MANAGER".
        List<String> urlPattern2 = new ArrayList<String>();

        urlPattern2.add("/userInfo");
        urlPattern2.add("/managerTask");

        mapConfig.put(ROLE_MANAGER, urlPattern2);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
}
