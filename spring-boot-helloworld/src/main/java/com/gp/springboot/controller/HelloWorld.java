package com.gp.springboot.controller;

import com.gp.springboot.bean.Student;
import com.gp.springboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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

    @ResponseBody
    @RequestMapping("/no-param")
    public String noParam(String name){
        return name;
    }

    @ResponseBody
    @GetMapping("/getparam")
    public String getParam(HttpServletRequest request){
        System.out.println(request.getAttribute("a"));
        return "first";
    }

    @GetMapping("/putparam")
    public String putParam(HttpServletRequest request){
        request.setAttribute("a", "value");
//        model.addAttribute("a", "value");
        return "forward:/getparam";
    }
}
