package org.sample.repository;

import java.sql.*;

public class H2ServerMode {

    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:h2:tcp://localhost/~/test";
        String username = "sa";
        String password = "1234";

        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
        System.out.println("Connected to H2 in server mode.");

        String sql = "SELECT * FROM students";

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        int count = 0;

        while (resultSet.next()) {
            count++;

            int ID = resultSet.getInt("ID");
            String name = resultSet.getString("name");
            System.out.println("Student #" + count + ": " + ID + ", " + name);
        }

        connection.close();
    }
}
