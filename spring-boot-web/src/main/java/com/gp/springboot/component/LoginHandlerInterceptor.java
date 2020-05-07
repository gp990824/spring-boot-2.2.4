package com.gp.springboot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gp
 * @create 2020/2/14 17:18
 */
//拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String result = (String) request.getSession().getAttribute("result");
        if (!StringUtils.isEmpty(result) && result.equals("success")) {
            return true;
        } else {
            request.setAttribute("message", "请先登录!");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }
    }
}
