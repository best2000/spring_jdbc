package dev.danvega;

import dev.danvega.model.User;
import dev.danvega.model.Permission;
import dev.danvega.repo.UserPermissionRepo;
import dev.danvega.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HelloJdbcApplication {

    private static final Logger log = LoggerFactory.getLogger(HelloJdbcApplication.class);

//    dependency injection
//    @Autowired
    private static UserRepo userRepo;
    private static UserPermissionRepo userPermissionRepo;

    public HelloJdbcApplication(UserRepo userRepo, UserPermissionRepo userPermissionRepo) {
        this.userRepo = userRepo;
        this.userPermissionRepo = userPermissionRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloJdbcApplication.class, args);

//        test userRepo methods
        String msg = userRepo.echo("lol");
        log.info("echo: {}",msg);

        List<User> users = userRepo.list();
        for (User user : users) {
            log.info(user.toString());
        }

//        test userPermissionRepo methods
        Permission permission = new Permission(
                users.get(1),
                3,
                "func1-app2"
        );
        log.info(permission.toString());
        userPermissionRepo.checkPermission(permission);
        log.info(permission.toString());

        userPermissionRepo.getPermission(users.get(0));
    }

}
