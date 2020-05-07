package com.gp.springboot.controller;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gp
 * @create 2020/2/13 19:45
 */
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public Map hello(@DefaultValue("1") @RequestParam("name") String name) {
        if ("aaa".equals(name)) {
            throw new RuntimeException("参数异常!");
        }
        HashMap<Object, Object> map = new HashMap<>();
        map.put("message", "Fuck you!");
        map.put("name", "Jack");
        return map;
    }

    /**
     * thymeleaf 会自动到classpath:/templates/下找 .html页面,相当于spring MVC的视图解析器
     *
     * @return
     */
    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("test", "Thymeleaf语法测试");
        map.put("laoba", Arrays.asList("臭豆腐", "俘虏", "黄瓜丝"));
        return "success";
    }
}
