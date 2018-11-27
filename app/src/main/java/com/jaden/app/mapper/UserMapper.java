package com.jaden.app.mapper;

import com.jaden.common.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by tangjiejin on 2018/11/27
 */
@Mapper
public interface UserMapper {

    User login(@Param("name") String name,@Param("password") String password);
}
