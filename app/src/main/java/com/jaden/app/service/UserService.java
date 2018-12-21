package com.jaden.app.service;

import com.jaden.app.mapper.UserInfoManualMapper;
import com.jaden.common.pojo.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by tangjiejin on 2018/11/27
 */
@Service
public class UserService {

    @Resource
    UserInfoManualMapper userInfoManualMapper;

    public UserInfo login(UserInfo userInfo) {
        return userInfoManualMapper.login(userInfo);
    }
}
