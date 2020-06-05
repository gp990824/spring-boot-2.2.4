package com.gp.springboot.controller;

import com.gp.springboot.dao.LoginDao;
import com.gp.springboot.dto.CommonResult;
import com.gp.springboot.dto.LoginResult;
import com.gp.springboot.entity.User;
import com.gp.springboot.service.LoginService;
import com.gp.springboot.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Gp
 * @create 2020/6/4 13:34
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("passWord") String passWord,
                        HttpServletRequest request) {
        if (userName == null || "".equals(userName) || passWord == null || "".equals(passWord)) {
            request.setAttribute("message", "没有填写用户名和密码!");
            return "index";
        }
        LoginResult loginResult = loginService.login(userName, passWord);
        if (loginResult != null) {
            //当密码正确
            if (loginResult.isLoginSuccess()) {
                User user = (User) loginResult.getData();
                request.getSession().setAttribute("user", user);
                return "redirect:/commodity/list";
            } else {
                //密码错误则携带错误信来到登录页面
                request.setAttribute("message", loginResult.getMessage());
                return "login";
            }
        } else {
            request.setAttribute("message", "系统异常!");
            return "error";
        }
    }
}
