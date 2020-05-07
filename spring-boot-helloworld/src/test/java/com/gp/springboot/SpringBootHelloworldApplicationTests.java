package com.gp.springboot;

import com.gp.springboot.bean.Student;
import com.gp.springboot.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 *springboot 的单元测试
 */
@SpringBootTest
class SpringBootHelloworldApplicationTests {

    @Autowired
    Student student;

    @Autowired
    ApplicationContext ioc;
    @Test
    void contextLoads() {
        System.out.println(student);
    }

    /**
     * 测试自己写的spring配置文件是否生效
     */
    @Test
    void testIOC(){
        System.out.println(ioc.containsBean("helloService"));
    }



}
