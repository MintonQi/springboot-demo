package com.minton.springbootdemo2.service;

import com.minton.springbootdemo2.dao.UserMapper;
import com.minton.springbootdemo2.entity.User;
import com.minton.springbootdemo2.util.TokenUtil;
import com.minton.springbootdemo2.vo.ResultInfo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {

    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public User findUserByName(String username){
        return userMapper.selectByName(username);
    }

    public User findUserById(int id){
        return userMapper.selectById(id);
    }

    public User addUser(User user){
        userMapper.insertUser(user);
        return findUserById(user.getId());
    }

    public ResultInfo loginCheck (User user, HttpServletResponse response) throws IOException {
        User user1 = userMapper.selectByName(user.getUsername());
        if(user1 == null){
            response.sendRedirect("/login");
            return ResultInfo.error("用户不存在！");
        }
        if(!user1.getPassword().equals(user.getPassword())){
            return ResultInfo.error("密码输入错误");
        }
        String token = TokenUtil.generateToken(user1);
        System.out.println("token: " + token);
        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/");
        response.addCookie(cookie);
        System.out.println("cookie:" + cookie);
        return ResultInfo.success("登录成功");
    }

}






