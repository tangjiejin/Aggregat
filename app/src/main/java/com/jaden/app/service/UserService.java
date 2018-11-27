package com.jaden.app.service;

import com.jaden.app.mapper.UserMapper;
import com.jaden.common.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tangjiejin on 2018/11/27
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User login(String name, String password) {

        return userMapper.login(name,password);
    }
}
