package com.example.securitywebapp.utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;

public class UrlPatternUtils {
    private static boolean hasUrlPattern(ServletContext servletContext, String urlPattern) {
        Map<String, ? extends ServletRegistration> map = servletContext.getServletRegistrations();

        for (String servletName: map.keySet()) {
            ServletRegistration servletRegistration = map.get(servletName);

            Collection<String> mappings = servletRegistration.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

    // servletPath:
    // ==> /spath
    // ==> /spath/*
    // ==> *.ext
    // ==> /
    public static String getUrlPattern(HttpServletRequest servletRequest) {
        ServletContext servletContext = servletRequest.getServletContext();
        String servletPath = servletRequest.getServletPath();
        String pathInfo = servletRequest.getPathInfo();

        String urlPattern = null;
        if (pathInfo != null) {
            urlPattern = servletPath + "/";
            return urlPattern;
        }

        urlPattern = servletPath;

        boolean has = hasUrlPattern(servletContext, urlPattern);

        if (has) {
            return urlPattern;
        }

        int i = servletPath.lastIndexOf(".");

        if (i != -1) {
            String ext = servletPath.substring(i + 1);
            urlPattern = "*." + ext;
            has = hasUrlPattern(servletContext, urlPattern);

            if (has) {
                return urlPattern;
            }
        }
        return "/";
    }
}
