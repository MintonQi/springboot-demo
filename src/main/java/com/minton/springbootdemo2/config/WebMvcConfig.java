package com.minton.springbootdemo2.config;

import com.minton.springbootdemo2.controller.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private AuthenticationInterceptor authenticationInterceptor;

    @Autowired
    public WebMvcConfig(AuthenticationInterceptor authenticationInterceptor){
        this.authenticationInterceptor = authenticationInterceptor;
    }

    @Override
    public void addInterceptors (InterceptorRegistry registry){
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/*")
                .excludePathPatterns("/login")
                .excludePathPatterns("/loginCheck");
    }

}
