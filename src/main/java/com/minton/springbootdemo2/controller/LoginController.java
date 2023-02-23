package com.minton.springbootdemo2.controller;

import com.minton.springbootdemo2.entity.User;
import com.minton.springbootdemo2.service.UserService;
import com.minton.springbootdemo2.vo.ResultInfo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/api/loginCheck")
    public ResultInfo login(@RequestBody User user, HttpServletResponse response) throws IOException {
        return userService.loginCheck(user, response);
    }
}
