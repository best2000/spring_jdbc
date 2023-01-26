package dev.danvega.repo;

import dev.danvega.model.User;
import dev.danvega.repo.mapper.UserRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {

    private static final Logger log = LoggerFactory.getLogger(UserRepoImpl.class);

    private JdbcTemplate jdbcTemplate;

//    manual dependency injection
    public UserRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> list() {
        String sql = "select * from user.user_detail";
        List <User> users = jdbcTemplate.query(sql, new UserRowMapper());
        return users;
    }

    @Override
    public String echo(String msg) {
        return msg;
    }



}