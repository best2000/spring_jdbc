package dev.danvega.repo;

import dev.danvega.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User(
                resultSet.getInt("user_id"),
                resultSet.getString("user_name")
        );
        return user;
    }
}
