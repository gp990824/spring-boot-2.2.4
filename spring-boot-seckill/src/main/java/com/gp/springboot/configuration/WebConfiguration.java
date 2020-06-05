package com.gp.springboot.configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.gp.springboot.component.LoginHandlerInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Gp
 * @create 2020/6/3 20:35
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/index.html","/css/**", "/js/**", "/img/**");
    }

    /**
     * 添加视图映射
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
    }

    /**
     * 配置 druid 连接池 后台
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> servletServletRegistrationBean() {
        ServletRegistrationBean<StatViewServlet> servlet = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        HashMap<String, String> map = new HashMap<>();
        map.put("loginUsername", "admin");
        map.put("loginPassword", "admin");
        //允许哪个ip访问, 如果不指定则所有ip地址都可以访问
        map.put("allow", "127.0.0.1");
        servlet.setInitParameters(map);
        return servlet;
    }

    /**
     * 过滤器, 拦截哪些请求
     * @return
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> filterFilterRegistrationBean(){
        FilterRegistrationBean<WebStatFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new WebStatFilter());
        HashMap<String, String> map = new HashMap<>();
        //这些资源不拦截
        map.put("exclusions","*.js,*.css,/druid/*");
        filter.setInitParameters(map);
        //拦截所有请求
        filter.setUrlPatterns(Arrays.asList("/*"));
        return filter;
    }
}
