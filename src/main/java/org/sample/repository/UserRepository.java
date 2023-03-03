package org.sample.repository;

import org.sample.entities.User;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.sample.repository.H2Connection.getConnection;

@Repository
public class UserRepository {

    private final String usersTable = "USERS";
    private final String SELECT = "SELECT";

    public List<User> findAll() {
        String sql = "SELECT * FROM " + usersTable;

        List<User> users = new ArrayList<>();

        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeLargeUpdate(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                users.add(new User(id, name, lastname));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public User findById(int id) {
        String sql = "SELECT * FROM " + usersTable + " WHERE id = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String password = resultSet.getString("password");

                return new User(id, name, lastname, password);
            } else {
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public User createUser(User user) {
        String sql = "INSERT INTO " + usersTable + " (name, lastname, password) " + "VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                user.setId(id);
            } else {
                System.out.println("User could not be created");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }


}
