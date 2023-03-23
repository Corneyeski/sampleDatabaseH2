package org.sample.repository;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {
    private static Connection connection;

    public H2Connection() {
        connection = initializeConnection();
    }

    public static Connection getConnection() {
        if(connection == null)
            connection = initializeConnection();
        return connection;
    }

    private static Connection initializeConnection() {
        String password = "1234";
        String username = "sa";
        String url = "jdbc:h2:file:~/db/h2/testdb;INIT=runscript from 'src/main/resources/sql/create.sql'\\;runscript from 'src/main/resources/sql/init.sql'";
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
