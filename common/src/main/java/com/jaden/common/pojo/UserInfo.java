package com.jaden.common.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class UserInfo {

    private Long id;

    private String name;

    private String phone;

    private Date createTime;

    private Integer state;

    private String password;

    private Date birthday;

    private String photo;

    private Byte gender;

    private String otp;
}