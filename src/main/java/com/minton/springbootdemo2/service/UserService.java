package com.minton.springbootdemo2.service;

import com.minton.springbootdemo2.dao.UserMapper;
import com.minton.springbootdemo2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}
