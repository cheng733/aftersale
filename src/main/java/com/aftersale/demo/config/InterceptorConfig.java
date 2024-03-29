package com.aftersale.demo.config;

import com.aftersale.demo.interceptor.ParamInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Autowired
    private ParamInterceptor paramInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        //此处配置拦截路径
        registry.addInterceptor(paramInterceptor).addPathPatterns("/**").excludePathPatterns("/login").excludePathPatterns("/register");
    }

}
