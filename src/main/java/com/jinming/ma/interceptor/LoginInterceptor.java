package com.jinming.ma.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @author majm
 * @create 2020-02-06 18:19
 * @desc
 **/
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        System.out.println("==========>>>>sessionId:" + session.getId());
        System.out.println("======SESSION::::" + session);
        Enumeration<String> attrs = session.getAttributeNames();
// 遍历attrs中的
        while (attrs.hasMoreElements()) {
// 获取session键值
            String name = attrs.nextElement().toString();
            // 根据键值取session中的值
            Object vakue = session.getAttribute(name);
            // 打印结果
            System.out.println("------" + name + ":" + vakue + "--------\n");

        }
        if (StringUtils.isEmpty(session.getAttribute("userName"))) {
            response.sendRedirect("/toLogin");
            return false;
        }

        if (session.getAttribute("userName") != null) {
            return true;
        }
        response.sendRedirect("/toLogin");
        return false;
    }
}
