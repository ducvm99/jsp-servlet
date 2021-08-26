package demo.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class WebsiteSession implements HttpSessionListener {

    private static int numberOfSession = 0;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().getServletContext().log("A new session was created " + ++numberOfSession);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().getServletContext().log("A session was destroyed " + --numberOfSession);
    }
}
