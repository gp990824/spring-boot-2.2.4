package com.gp.springboot.config;

import com.gp.springboot.component.LoginHandlerInterceptor;
import com.gp.springboot.component.MyLocalResovler;
import com.gp.springboot.component.MyServlet;
import org.springframework.boot.web.embedded.tomcat.ConfigurableTomcatWebServerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author gp
 * @create 2020/2/14 13:19
 */
//@EnableWebMvc//全面接管springboot配置的springMVC自动配置类,WebMvcAutoConfiguraion自动配置类就失效了
@Configuration//告知Spring这是一个自动配置类
public class MyMVCConfig implements WebMvcConfigurer {
    //添加视图解析
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/", "/index.html", "/user/login");
    }

    //注册国际化信息,想要让其生效,方法名一定要为其类名的首字母小写
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResovler();
    }


    //注册定制的servlet(filter(FilterRegistrationBean<T>,listener(ServletListenerRegistrationBean<T>同样如此)
    @Bean
    public ServletRegistrationBean<MyServlet> servletServletRegistrationBean() {
        return new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
    }

}
