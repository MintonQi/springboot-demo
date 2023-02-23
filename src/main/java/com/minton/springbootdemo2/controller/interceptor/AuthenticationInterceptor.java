package com.minton.springbootdemo2.controller.interceptor;

import com.minton.springbootdemo2.util.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    private TokenUtil tokenUtil;

    @Autowired
    public AuthenticationInterceptor(TokenUtil tokenUtil){
        this.tokenUtil = tokenUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws IOException {
        // 检查request中是否存在token不存在啧跳转登录页面
        String token = tokenUtil.getToken(request);
        if(token == null || token.isEmpty()){
            System.out.println("No token");
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }



}
