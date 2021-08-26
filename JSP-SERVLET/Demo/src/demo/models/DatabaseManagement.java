package demo.models;

public class DatabaseManagement {
    public boolean checkUser(String username, String password) {
        // Voi DB: Tao Query de check
        return username.equals("minhduc") && password.equals("123");
    }
}
