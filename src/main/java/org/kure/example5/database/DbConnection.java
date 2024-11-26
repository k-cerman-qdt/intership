package org.kure.example5.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private final String jdbcUrl;
    private final String username;
    private final String password;

    /**
     * @param jdbcUrl
     * jdbc:mysql://hostname:port/dbName?useSSL=false;
     * @param username
     * @param password
     */
    public DbConnection(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    public Connection createConnection() throws SQLException {
        try {
            return DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            System.out.println("Failed to create connection");
            throw e;
        }
    }
}
