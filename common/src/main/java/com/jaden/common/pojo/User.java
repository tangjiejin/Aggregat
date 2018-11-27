package com.jaden.common.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Created by tangjiejin on 2018/11/21
 */
@Data
public class User {

    Long id;

    String name;

    String photo;

    Date birthday;

    String password;

    String phone;

    Date createTime;

    Integer state;

}
