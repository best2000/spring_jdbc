package dev.danvega.repo;

import dev.danvega.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;

@Repository
public class UserPermissionRepoImpl implements UserPermissionRepo{

    private static final Logger log = LoggerFactory.getLogger(UserPermissionRepo.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Permission checkPermission(Permission permission) {
        String sql = "SELECT EXISTS( \n"+
                "SELECT 1 FROM ccwp.group_function gf \n"+
                "INNER JOIN user.user_group ug \n"+
                    "ON gf.group_id = ug.group_id \n"+
                "WHERE ug.user_id = ? \n"+
                    "AND gf.function_id = ? \n"+
                ")";
         Boolean permissionChecked = jdbcTemplate.queryForObject(sql, new Object[]{
                permission.getUser().getId(),
                permission.getAppFunctionId()
         }, Boolean.class);
        if (permissionChecked == true) {
            permission.setStatus(Permission.verificationStatus.PASSED);
        } else {
            permission.setStatus(Permission.verificationStatus.FAILED);
        }
        return permission;
    }

    @Override
    public List<AppMenu> getPermission(User user) {
        String sql = "SELECT ad.app_name, af.app_id, af.function_id, af.function_name\n" +
                "FROM ccwp.group_function gf \n" +
                "INNER JOIN user.user_group ug \n" +
                "    ON ug.group_id = gf.group_id\n" +
                "INNER JOIN ccwp.app_function af \n" +
                "    ON af.function_id = gf.function_id \n" +
                "INNER JOIN ccwp.app_detail ad \n" +
                "    ON ad.app_id = af.app_id\n" +
                "WHERE ug.user_id = ?\n"+
                "ORDER BY ad.app_name ASC, af.function_name ASC";

        List <Menu> menus = jdbcTemplate.query(sql,new Object[]{user.getId()},(rs, rowNum) ->
                new Menu( rs.getString("app_name"),
                        rs.getInt("app_id"),
                        rs.getString("function_name"),
                        rs.getInt("function_id"))
        );

        List<AppMenu> appMenuList = new ArrayList<>();
        List<AppFunction> appFunctionList = new ArrayList<>();
        AppMenu prevAppMenu = new AppMenu(999999,"not exist");
        for (Menu menu : menus) {
            AppMenu appMenu = new AppMenu(menu.getApp_id(),menu.getApp_name());
            AppFunction appFunction = new AppFunction(menu.getFunction_id(),menu.getFunction_name());
            if (prevAppMenu.getApp_name() != appMenu.getApp_name()){
                log.info("add app: {}",appMenu.getApp_name());
                appMenuList.add(appMenu);
                prevAppMenu.setFunctions(appFunctionList);
                appFunctionList = new ArrayList<>();
                prevAppMenu = appMenu;
            }
            appFunctionList.add(appFunction);
        }
        prevAppMenu.setFunctions(appFunctionList);

        System.out.println(appMenuList.size());
//        System.out.println(appMenuList.get(0).getFunctions().size());
//        System.out.println(appMenuList.get(1).getFunctions().size());

        return appMenuList;
    }
}