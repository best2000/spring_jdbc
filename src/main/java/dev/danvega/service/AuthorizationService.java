package dev.danvega.service;

import dev.danvega.model.*;
import dev.danvega.model.Menu.AppFunctionMenu;
import dev.danvega.model.Menu.AppMenu;
import dev.danvega.model.Menu.Menu;
import dev.danvega.repo.UserPermissionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorizationService {
    private static final Logger log = LoggerFactory.getLogger(AuthorizationService.class);
    @Autowired
    private UserPermissionRepo userPermissionRepo;

    public List<AppMenu> getPermission(User user) {
        //get menu data according to user permission
        List<Menu> menus = userPermissionRepo.getPermission(user);
        //prepare menu object for front end (JSON)
        List<AppMenu> appMenuList = new ArrayList<>();
        List<AppFunctionMenu> appFunctionMenuList = new ArrayList<>();
        AppMenu prevAppMenu = new AppMenu();
        for (Menu menu : menus) {
            AppMenu appMenu = new AppMenu(menu.getApp_id(), menu.getApp_name());
            AppFunctionMenu appFunctionMenu = new AppFunctionMenu(menu.getFunction_id(), menu.getFunction_name());
            if (prevAppMenu.getApp_name() != appMenu.getApp_name()) {
                log.info("add app: {}", appMenu.getApp_name());
                appMenuList.add(appMenu);
                prevAppMenu.setFunctions(appFunctionMenuList);
                appFunctionMenuList = new ArrayList<>();
                prevAppMenu = appMenu;
            }
            appFunctionMenuList.add(appFunctionMenu);
        }
        prevAppMenu.setFunctions(appFunctionMenuList);
        return appMenuList;
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
