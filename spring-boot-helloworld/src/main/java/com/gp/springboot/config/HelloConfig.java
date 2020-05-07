package com.gp.springboot.config;

import com.gp.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gp
 * @create 2020/2/13 12:29
 */

/**
 * 告知springboot这是一个配置类,替代之前的spring配置文件
 */
//@Configuration
public class HelloConfig {
    //容器中的bean就是该方法的返回值,id就是方法名
//    @Bean
    public HelloService helloService(){
        System.out.println("配置类正在执行...");
        return new HelloService();
    }
}
