package dev.danvega.repo;

import dev.danvega.model.User;

import java.util.List;
import java.util.Optional;


public interface UserRepo {
    List<User> list();
    String echo(String msg);

}