package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private Connection connection;

    public DataBaseConnection() {
        int port = 3306;
        String dbName = "ParaBankATF";
        String user = "root";
        String password = "root";

        String url = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:" + port + "/" + dbName);
        String dbUser = System.getenv().getOrDefault("DB_USER", user);
        String dbPassword = System.getenv().getOrDefault("DB_PASSWORD", password);

        try {
            connection = DriverManager.getConnection(url, dbUser, dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed: " + e.getMessage(), e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}