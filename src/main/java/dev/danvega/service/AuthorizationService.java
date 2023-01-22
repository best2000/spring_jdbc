package dev.danvega.service;

import dev.danvega.model.AppMenu;
import dev.danvega.model.Permission;
import dev.danvega.model.User;
import dev.danvega.repo.UserPermissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {

    @Autowired
    private UserPermissionRepo userPermissionRepo;

    public List<AppMenu> getPermission(User user) {
        return userPermissionRepo.getPermission(user);
    }

    public Permission authorize(User user, Integer function_id) {
        Permission permission = new Permission(
                user,
                function_id,
                "?"
        );
        return userPermissionRepo.checkPermission(permission);
    }
}
