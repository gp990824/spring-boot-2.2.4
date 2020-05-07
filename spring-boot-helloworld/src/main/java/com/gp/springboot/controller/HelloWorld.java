package com.gp.springboot.controller;

import com.gp.springboot.bean.Student;
import com.gp.springboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gp
 * @create 2020/2/12 18:49
 */
@Controller
public class HelloWorld {
    @Autowired
    Student student;
    @Autowired
    HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        System.out.println(student);
        return "Hello World!";
    }
}
