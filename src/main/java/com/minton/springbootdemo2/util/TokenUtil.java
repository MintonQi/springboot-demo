package com.minton.springbootdemo2.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.minton.springbootdemo2.entity.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.List;

@Component
public class TokenUtil {
    /**
     * generate token
     * 生成token
     */
    public static String generateToken(User user){
        Date start = new Date();
        // 3 hours' valid time
        Date end = new Date(System.currentTimeMillis() + 3*60*60*1000);
        return JWT.create()
                .withAudience(Integer.toString(user.getId()))
                .withAudience(user.getUsername())
                .withIssuedAt(start)
                .withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
    }

    /**
     * get userId from specific token
     * 从token获取userId
     */
    public static String getIdFromToken(String token){
        List<String> list = JWT.decode(token).getAudience();
        return list.get(0);
    }


    /**
     * get request
     * 获取request
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }

    /**
     * get token from cookies
     * 从cookies获取token
     */
    public String getToken(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie c : cookies){
            if(c.getName() == "token"){
                return c.getValue();
            }
        }
        return null;
    }

}







