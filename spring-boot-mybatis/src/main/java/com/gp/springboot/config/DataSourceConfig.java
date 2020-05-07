package com.gp.springboot.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author gp
 * @create 2020/2/16 21:02
 */
@Configuration
public class DataSourceConfig {
    /**
     *     配置Druid
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> servletServletRegistrationBean(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        HashMap<String, String> hashMap = new HashMap<>();
        //根据StatViewServlet的父类 ResourceServlet 的属性进行配置( ResourceServlet继承自 HttpServlet )
        hashMap.put("loginUsername","admin");//登录druid后台的账号
        hashMap.put("loginPassword","123");//密码
        hashMap.put("allow","127.0.0.1");//允许谁访问,默认允许所有
        bean.setInitParameters(hashMap);
        return bean;
    }

    /**
     * 配置一个Web监控的Filter
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> filterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean<WebStatFilter>();
        bean.setFilter(new WebStatFilter());
        HashMap<String, String> hashMap = new HashMap<>();
        //根据 WebStatFilter 属性进行配置
        hashMap.put("exclusions","*.js,*.css,/druid/*");//这些请求不拦截
        bean.setInitParameters(hashMap);
        bean.setUrlPatterns(Arrays.asList("/*"));//拦截所有请求
        return bean;
    }
}
