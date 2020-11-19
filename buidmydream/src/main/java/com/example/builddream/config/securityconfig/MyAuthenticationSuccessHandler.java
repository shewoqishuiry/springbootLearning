package com.example.builddream.config.securityconfig;


import com.example.builddream.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author longzhonghua
 * @data 2/26/2019 6:48 PM
 */
@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    private RequestCache requestCache = new HttpSessionRequestCache();
    //用户名和密码正确执行
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal != null && principal instanceof UserDetails) {
//            UserDetails user = (UserDetails) principal;
//            httpServletResponse.setContentType("application/json;charset=utf-8");
//            PrintWriter out = httpServletResponse.getWriter();
//            out.write("{\"status\":\"ok\",\"message\":\"登录成功\"}");
//            out.flush();
//            out.close();
//        }

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null && principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            String userName = userDetails.getUsername();
            try {
                String successDefaultUrl = userService.getUserLoginSuccessUrl(userName);
                // 这里有一个很明显的跳转操作，追踪targetUrl怎么来的
                getRedirectStrategy().sendRedirect(httpServletRequest, httpServletResponse, successDefaultUrl);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }

}
