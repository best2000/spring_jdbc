package dev.danvega.controller;

import dev.danvega.exception.CustomException;
import dev.danvega.model.AuthReqBody;
import dev.danvega.model.Menu.AppMenu;
import dev.danvega.model.Menu.UserSession;
import dev.danvega.model.User;
import dev.danvega.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public Integer authorize(@RequestBody AuthReqBody authReqBody, HttpServletRequest httpServletRequest) {
        Object userSession = httpServletRequest.getAttribute("userSession");
        String userLogin = ((UserSession) userSession).getUserLogin();
        return authorizationService.authorize(userLogin, authReqBody.getApp_code(), authReqBody.getFunction_code());
    }

    @GetMapping("/throw")
    public void exceptionTest() {
        throw new CustomException("Just throw!");
    }


}
