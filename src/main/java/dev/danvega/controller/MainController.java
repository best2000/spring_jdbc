package dev.danvega.controller;

import dev.danvega.exception.CustomException;
import dev.danvega.model.AuthReqBody;
import dev.danvega.model.Menu.AppMenu;
import dev.danvega.model.ResponseTemplate.ResponseTemplate;
import dev.danvega.model.UserSession;
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
    public Object healthCheck(HttpServletRequest httpServletRequest) {
        Object responseTemplateObject = httpServletRequest.getAttribute("responseTemplate");
        return responseTemplateObject;
    }

    @GetMapping("/permission")
    public Object getPermission(HttpServletRequest httpServletRequest) {
        Object userSession = httpServletRequest.getAttribute("userSession");
        Object responseTemplateObject = httpServletRequest.getAttribute("responseTemplate");

        String userLogin = ((UserSession) userSession).getUserLogin();
        List<AppMenu> appMenus = authorizationService.getPermission(userLogin);

        ResponseTemplate responseTemplate = ((ResponseTemplate) responseTemplateObject);
        responseTemplate.setData(appMenus);
        return responseTemplate;
    }

    @GetMapping("/authorize")
    public Object authorize(@RequestBody AuthReqBody authReqBody, HttpServletRequest httpServletRequest) {
        Object userSession = httpServletRequest.getAttribute("userSession");
        Object responseTemplateObject = httpServletRequest.getAttribute("responseTemplate");

        String userLogin = ((UserSession) userSession).getUserLogin();
        Integer authStatus = authorizationService.authorize(userLogin, authReqBody.getApp_code(), authReqBody.getFunction_code());

        ResponseTemplate responseTemplate = ((ResponseTemplate) responseTemplateObject);
        responseTemplate.setData(authStatus);
        return responseTemplate;
    }

    @GetMapping("/throw")
    public void exceptionTest() {
        throw new CustomException("Just throw!");
    }


}
