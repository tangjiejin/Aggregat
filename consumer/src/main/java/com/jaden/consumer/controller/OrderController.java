package com.jaden.consumer.controller;

import com.jaden.common.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tangjiejin on 2018/11/27
 */
@RestController
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/consumer/toLogin")
    public User toLogin(){

        return restTemplate.getForEntity("http://APP/user/login?name=jaden&password=123",User.class).getBody();
    }

}
