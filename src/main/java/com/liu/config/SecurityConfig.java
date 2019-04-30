package com.liu.config;

import com.liu.interceptor.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: vms
 * @author: smile liu
 * @description: 拦截器注入配置
 * @create: 2019-02-18 12:32
 **/
@Configuration
public class SecurityConfig extends WebMvcConfigurerAdapter {
    @Bean
    public SecurityInterceptor securityInterceptor(){
        return new SecurityInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/selectToLogin","/static/**");
        super.addInterceptors(registry);
    }
}
