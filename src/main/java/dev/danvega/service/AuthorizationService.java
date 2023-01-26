package dev.danvega.service;

import dev.danvega.model.*;
import dev.danvega.model.Menu.AppFunction;
import dev.danvega.model.Menu.AppMenu;
import dev.danvega.model.Menu.FunctionMenu;
import dev.danvega.model.Menu.SubFunctionMenu;
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

    public List<AppMenu> getPermission(String userLogin) {
        log.info("AuthorizationService.getPermission => userLogin={}",userLogin);

        List<AppFunction> appFunctions = userPermissionRepo.getPermission(userLogin);
        List<AppMenu> appMenus = new ArrayList<>();
        String app_code;
        String app_name;
        String function_code;
        String function_name;
        AppMenu lastAppMenu = null;
        FunctionMenu lastFunctionMenu = null;

        System.out.println(appFunctions.size());

        for (AppFunction appFunction : appFunctions) {
            //update current loop vars
            app_code = appFunction.getApp_code();
            app_name = appFunction.getApp_name();
            function_code = appFunction.getFunction_code();
            function_name = appFunction.getFunction_name();

            log.info("app_code={}, app_name={}, function_code={}, function_name={}",app_code,app_name,function_code,function_name);

            System.out.println("check AppMenu");
            //if last appMenus element not the same as current appMenu
            if (appMenus.isEmpty()
                    || !(appMenus.get(appMenus.size() - 1).getApp_code()).equals(app_code)) {
                System.out.println("add to AppMenu");
                //add new 'AppMenu' to 'appMenus' list
                appMenus.add(new AppMenu(app_code, app_name, new ArrayList<>()));
            }
            //update var
            lastAppMenu = appMenus.get(appMenus.size() - 1);

            System.out.println("check Function");
            //if function_code is 'FunctionMenu' of last 'AppMenu' in 'appMenus' list
            if ((function_code.substring(function_code.length() - 2).equals("00"))
                    && (app_code.equals(lastAppMenu.getApp_code()))) {
                System.out.println("add to function");
                //add new 'FunctionMenu' to last 'AppMenu'
                lastAppMenu.getFunctions().add(new FunctionMenu(function_code, function_name, new ArrayList<SubFunctionMenu>()));
                lastFunctionMenu = lastAppMenu.getFunctions().get(lastAppMenu.getFunctions().size() - 1);
            }
            //else if function_code is 'SubFunctionMenu' of last 'FunctionMenu'
            else if ((function_code.substring(0,3).equals(lastFunctionMenu.getFunction_code().substring(0,3)))
                    && (app_code.equals(lastAppMenu.getApp_code()))){
                System.out.println("add to sub_function");
                //add new 'SubFunctionMenu' to last 'FunctionMenu'
                lastFunctionMenu.getSub_functions().add(new SubFunctionMenu(function_code, function_name));
            }
        }
        return appMenus;
    }

    public Integer authorize(String userLogin, String appCode, String functionCode) {
        return userPermissionRepo.checkUserPermission(userLogin,appCode,functionCode);
    }
}
