package dev.danvega.dao;

import dev.danvega.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CourseJdbcDAO {

    private static final Logger log = LoggerFactory.getLogger(CourseJdbcDAO.class);
    private JdbcTemplate jdbcTemplate;

    public CourseJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Course> rowMapper = (rs,rowNum)->{
        Course course = new Course();
        course.setId(rs.getInt("id"));
        course.setTitle(rs.getString("title"));
        course.setTeacherId(rs.getString("teacher_id"));
        return course;
    };


    public List<Course> list() {
        String sql = "SELECT id, title, teacher_id from course";
        return jdbcTemplate.query(sql,rowMapper);
    }


    public void create(Course course) {

    }


    public Optional<Course> get(int id) {
        return Optional.empty();
    }


    public void update(Course course, int id) {

    }


    public void delete(int id) {

    }


}