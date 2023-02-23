package com.minton.springbootdemo2.controller;

import com.alibaba.fastjson2.JSONObject;
import com.minton.springbootdemo2.entity.User;
import com.minton.springbootdemo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public Object addUser(@RequestBody User user){
        JSONObject jsonObject = new JSONObject();
        if(userService.findUserByName(user.getUsername()) != null){
            jsonObject.put("code", 4001);
            jsonObject.put("msg", "username has been used");
            jsonObject.put("data", "");
        } else {
            userService.addUser(user);
            jsonObject.put("code", 2011);
            jsonObject.put("msg", "User created!");
            jsonObject.put("data", "");
        }
        return jsonObject;
    }
}
