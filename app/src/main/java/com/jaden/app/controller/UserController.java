package com.jaden.app.controller;

import com.jaden.common.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by tangjiejin on 2018/11/21
 */
@RestController
public class UserController {

    @GetMapping("/user/login")
    public User login(String name){
        User user = new User();
        user.setName(name);
        user.setBirthday(new Date());
        user.setAge(100);
        user.setPhoto("http://xxxxx.jpg");
        return user;
    }

}
