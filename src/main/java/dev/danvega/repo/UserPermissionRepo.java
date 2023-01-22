package dev.danvega.repo;

import dev.danvega.model.AppMenu;
import dev.danvega.model.Permission;
import dev.danvega.model.User;

import java.util.List;


public interface UserPermissionRepo {
    Permission checkPermission(Permission permission);

    List<AppMenu> getPermission(User user);
}
