package org.sample.repository.example.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2EmbeddedExample {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:h2:file:~/db/h2/testdb;INIT=runscript from 'src/main/resources/sql/create.sql'\\;runscript from 'src/main/resources/sql/init.sql'";

        /*
        String connectionUrl = "jdbc:h2:~/test";
        String parameter = "INIT=runscript";
        String createSQl = "from 'src/main/resources/sql/create.sql';";
        String initSQl = "runscript from 'src/main/resources/sql/init.sql'";
        */

        String username = "sa";
        String password = "1234";

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to H2 embedded database.");

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