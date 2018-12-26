package com.jaden.app.pojo;

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

}