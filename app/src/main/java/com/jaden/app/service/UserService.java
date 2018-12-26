package com.jaden.app.service;

import com.jaden.app.mapper.UserInfoManualMapper;
import com.jaden.app.models.UserInfoModel;
import com.jaden.common.exception.BizException;
import com.jaden.common.pojo.UserInfo;
import com.jaden.common.result.ResultData;
import com.jaden.common.result.ResultStateEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by tangjiejin on 2018/11/27
 */
@Service
public class UserService {

    @Resource
    UserInfoManualMapper userInfoManualMapper;

    public UserInfo login(String phone, String password) {
        return userInfoManualMapper.login(phone,password);
    }

    public ResultData register(UserInfoModel userModel) throws BizException {
        UserInfo existUser =  userInfoManualMapper.selectByPhone(userModel.getPhone());
        if (existUser != null){
            throw new BizException(ResultStateEnum.PARAMETER_ERROR,"用户已存在");
        }
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userModel,userInfo);
        userInfoManualMapper.insertSelective(userInfo);
        return ResultData.retSuccess("注册成功");
    }
}
