package com.jaden.app.controller;

import com.jaden.app.service.UserService;
import com.jaden.common.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangjiejin on 2018/11/21
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/login")
    public User login(String name,String password){

        return userService.login(name,password);
    }

}
