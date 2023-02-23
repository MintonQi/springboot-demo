package com.minton.springbootdemo2.controller;

import com.minton.springbootdemo2.entity.User;
import com.minton.springbootdemo2.service.UserService;
import com.minton.springbootdemo2.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResultInfo addUser(@RequestBody User user){
        if(userService.findUserByName(user.getUsername()) != null){
            return ResultInfo.error("用户名已被占用！");
        } else {
            userService.addUser(user);
            return ResultInfo.success(user);
        }
    }
}
