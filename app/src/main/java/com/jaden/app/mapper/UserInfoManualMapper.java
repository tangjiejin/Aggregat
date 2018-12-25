package com.jaden.app.mapper;

import com.jaden.common.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoManualMapper extends UserInfoMapper {

    UserInfo login(@Param("phone") String phone,@Param("password") String password);

    UserInfo selectByPhone(String phone);
}