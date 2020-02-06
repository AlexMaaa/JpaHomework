package com.jinming.ma.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author majm
 * @create 2020-02-06 18:19
 * @desc
 **/
public class LoginInterceptor implements HandlerInterceptor {
   static Boolean isLogin = false;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        if (isLogin){
            return true;
        }
        if (StringUtils.isEmpty(userName) && StringUtils.isEmpty(passWord)) {
            response.sendRedirect("/toLogin");
            return false;
        }

        if (userName.equals("admin") && passWord.equals("admin")) {
            isLogin = true;
            return true;

        }
        response.sendRedirect("/toLogin");
        return false;
    }
}
