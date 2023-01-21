package dev.danvega;

import dev.danvega.dao.CourseJdbcDAO;
import dev.danvega.dao.DAO;
import dev.danvega.model.Course;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

import static java.lang.System.*;

@SpringBootApplication
public class HelloJdbcApplication {

    private static CourseJdbcDAO dao;

    public HelloJdbcApplication(CourseJdbcDAO dao) {
        this.dao = dao;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloJdbcApplication.class, args);

        System.out.println("STARTED!");

        List<Course> courses = dao.list();
        courses.forEach(System.out::println);
    }

}
