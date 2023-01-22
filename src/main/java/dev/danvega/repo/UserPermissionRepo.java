package dev.danvega.repo;

import dev.danvega.model.Menu.Menu;
import dev.danvega.model.Permission;
import dev.danvega.model.User;

import java.util.List;


public interface UserPermissionRepo {
    Permission checkPermission(Permission permission);

    List<Menu> getPermission(User user);
}
