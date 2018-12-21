package com.jaden.consumer.controller;

import com.jaden.common.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public UserInfo toLogin(){
        String name = "jaden";
        Integer password = 123;
        return restTemplate.getForEntity("http://APP/user/login?name={1}&password={2}",UserInfo.class,name,password).getBody();
    }

}
