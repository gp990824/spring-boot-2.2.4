package com.gp.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 主程序类,springboot应用的入口
 * @SpringBootApplication 他是一个组合注解, 有以下几个注解组成:
 *      @SpringBootConfiguration :标注在某个类上,表示这是一个springboot的配置类
 *          @Configuration : 属于spring的注解 , 配置类上来标注这个注解
 *              配置类:用于配置文件,其实也是ioc容器中的一个组件@Component
 *      @EnableAutoConfiguration : 开启自动配置功能,以前我们需要配置的东西,springboot帮我们自动配置
 *          @AutoConfigurationPackage : 自动配置包
 *              @Import(AutoConfigurationPackages.Registrar.class) :属于spring的注解,给容器导入一个组件
 *                  将主配置类所在的包和其子包的所有组件扫描到spring容器中
 *          @Import(AutoConfigurationImportSelector.class) : 给容器中导入组件,AutoConfigurationImportSelector有一个方法:
 *              getAutoConfigurationEntry   将所有需要导入的组件以AutoConfigurationEntry返回
 *              这些组件就会被添加到ioc容器中(会给容器中导入很多个自动配置类),免去了手动编写配置注入功能组件的工作
 *              Spring Boot在启动的时候从类路径(autoconfiguration包)下的META-INF/spring.factories中
 *              获取EnableAutoConfiguration指定的值,将这些值作为自动配置类导入到容器中，自动配置类就生效,帮我们进行自动配置工作
 *              javaEE整体整合方案和自动配置都在org.springframework.boot.autoconfiguration包下
 */
//@ImportResource(locations = {"classpath:ioc.xml"})//让springboot识别自己编写的spring配置文件,不推荐使用该方式
@SpringBootApplication
public class SpringBootHelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloworldApplication.class, args);
    }

}
