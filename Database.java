package by.gsu.pms.task11.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private Connection conn;

    public Database(String url, String user_name, String password) {
        conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            this.conn = DriverManager.getConnection(url, user_name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }
}