package com.gp.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author gp
 * @create 2020/2/13 11:09
 */
//将本类中的所有属性和配置文件(默认全局配置文件)中的值进行绑定 prefix = "student" 配置文件中的那个属性下的属性
//@PropertySource(value = {"classpath:student.properties"})//从指定的配置文件中获取值,先把其他的配置信息注释掉
@ConfigurationProperties(prefix = "student")//默认从全局配置文件中找
@Component
public class Student {
    private String name;
    private int age;
    private List<String> hobbies;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
