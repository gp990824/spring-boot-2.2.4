package com.gp.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gp
 * @create 2020/2/16 16:43
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }
}
