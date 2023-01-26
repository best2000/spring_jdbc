package dev.danvega.repo.mapper;

import dev.danvega.model.Menu.AppFunction;
import dev.danvega.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppFunctionRowMapper implements RowMapper<AppFunction> {

    @Override
    public AppFunction mapRow(ResultSet resultSet, int i) throws SQLException {
        AppFunction appFunction = new AppFunction(
                resultSet.getString("app_name"),
                resultSet.getString("app_code"),
                resultSet.getString("function_name"),
                resultSet.getString("function_code")
        );
        return appFunction;
    }
}
