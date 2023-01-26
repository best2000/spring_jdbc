package dev.danvega.interceptor;

import dev.danvega.model.ResponseTemplate.ResponseTemplate;

import dev.danvega.model.ResponseTemplate.ResponseTemplateStatus;
import dev.danvega.model.UserSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MainInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        UserSession userSession = new UserSession(httpServletRequest.getHeader("Authorization"));
        httpServletRequest.setAttribute("userSession",userSession);

        ResponseTemplateStatus status = new ResponseTemplateStatus(200,"success");
        ResponseTemplate responseTemplate = new ResponseTemplate(status,null);
        httpServletRequest.setAttribute("responseTemplate",responseTemplate);

        return true;
    }

//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        //
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//        //
//    }
}
