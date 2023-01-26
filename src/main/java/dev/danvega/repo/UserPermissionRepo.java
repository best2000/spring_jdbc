package dev.danvega.repo;

import dev.danvega.model.Menu.AppFunction;
import dev.danvega.model.User;

import java.util.List;


public interface UserPermissionRepo {
    Integer checkUserPermission(String userLogin, String appCode, String functionCode);

    List<AppFunction> getPermission(String userLogin);
}
