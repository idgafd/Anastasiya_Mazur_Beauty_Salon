// ConnectionPool.java
package main.java.org.webproject.conection;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "pass";
    private static ConnectionPool instance = null;
    private Connection connection;

    private ConnectionPool() throws SQLException {
        PGSimpleDataSource source = new PGSimpleDataSource();
        source.setDatabaseName("db_pis");
        source.setUser(USERNAME);
        source.setPassword(PASSWORD);
        connection = source.getConnection();
    }

    public static ConnectionPool getInstance() throws SQLException {
        if (instance == null)
            instance = new ConnectionPool();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void releaseConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

