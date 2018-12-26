package com.jaden.app.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by tangjiejin on 2018/12/26
 */
@Data
public class UserInfoModel {

    private Long id;

    @NotBlank(message = "姓名不能为空")
    private String name;

    @Length(min = 11,max = 11,message = "手机号不合法")
    private String phone;

    private Date createTime;

    private Integer state;

    @Size(min = 3,max = 10,message = "密码长度必须在3-10位")
    private String password;

    private Date birthday;

    private String photo;

    private Byte gender;

    private String otp;

}
