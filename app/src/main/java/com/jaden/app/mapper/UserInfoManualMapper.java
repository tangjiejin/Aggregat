package com.jaden.app.mapper;

import com.jaden.common.pojo.UserInfo;

public interface UserInfoManualMapper extends UserInfoMapper {

    UserInfo login(UserInfo userInfo);

}