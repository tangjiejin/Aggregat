package com.jaden.app.mapper;

import com.jaden.app.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo login(@Param("phone") String phone, @Param("password") String password);

    UserInfo selectByPhone(String phone);
}