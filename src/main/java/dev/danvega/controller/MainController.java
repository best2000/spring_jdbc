package dev.danvega.controller;

import dev.danvega.model.Menu.AppMenu;
import dev.danvega.model.Permission;
import dev.danvega.model.User;
import dev.danvega.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private AuthorizationService authorizationService;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "ok";
    }
    @GetMapping("/permission")
    public List<AppMenu> getPermission(@RequestBody User user) {
        return authorizationService.getPermission(user);
    }

    @GetMapping("/authorize")
    public Permission authorize(@RequestBody User user,@RequestParam("function_id") Integer function_id) {
        return authorizationService.authorize(user,function_id);
    }


}
