package dev.danvega.repo;

import dev.danvega.model.Menu.Menu;
import dev.danvega.model.Permission;
import dev.danvega.model.User;

import java.util.List;


public interface UserPermissionRepo {
    Integer checkUserPermission(String userLogin, String appCode, String functionCode);

    List<Menu> getPermission(User user);
}
