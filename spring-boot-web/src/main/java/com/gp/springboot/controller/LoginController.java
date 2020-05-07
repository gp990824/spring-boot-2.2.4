package com.gp.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author gp
 * @create 2020/2/14 16:52
 */
@Controller
public class LoginController {
//    @PostMapping
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String userLogin(String username, @RequestParam("password") String pwd, Map<String,Object> map,
                            HttpSession session){
        if(username.equals("admin") && pwd.equals("123")){
            //防止表单重复提交,使用重定向的方式访问页面
            session.setAttribute("result","success");
            session.setAttribute("loginUsername",username);
            return "redirect:/main.html";
        }else {
            map.put("message","用户名与密码不匹配");
            return "login";
        }
    }
}
