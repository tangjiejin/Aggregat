package com.jaden.app.controller;

import com.jaden.app.models.UserInfoModel;
import com.jaden.app.service.UserService;
import com.jaden.app.validator.ValidationResult;
import com.jaden.app.validator.ValidatorImpl;
import com.jaden.common.exception.BizException;
import com.jaden.common.pojo.UserInfo;
import com.jaden.common.result.ResultData;
import com.jaden.common.result.ResultStateEnum;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tangjiejin on 2018/11/21
 */
@RestController
public class UserController extends BaseController{

    @Autowired
    UserService userService;

    @Autowired
    HttpServletRequest request;

    /**
     * 用户登录
     * @return
     * @throws Exception
     */
    @GetMapping("/user/login")
    public ResultData login(String phone,String password) throws BizException {

        if (StringUtils.isBlank(phone) || StringUtils.isBlank(password)){
            throw new BizException(ResultStateEnum.PARAMETER_ERROR);
        }
        UserInfo userInfo = userService.login(phone,password);
        return ResultData.retSuccess(userInfo);
    }

    /**
     * 获取验证码
     * @param phone
     * @return
     * @throws Exception
     */
    @GetMapping("/user/getOtp")
    public ResultData getOtp(String phone) throws Exception {
        if (phone == null || phone.trim().length() <= 0){
            throw new BizException(ResultStateEnum.PARAMETER_ERROR,"手机号不能为空");
        }
        int otp = RandomUtils.nextInt(9999);
        otp = otp < 1000 ? otp + 1000 : otp;
        request.getSession().setAttribute(phone,String.valueOf(otp));
        System.out.println("手机号：" + phone + ",验证码：" + otp);
        return ResultData.retSuccess("验证码已发送，请注意查收！");
    }

    /**
     * 用户注册
     * @param userModel
     * @return
     * @throws BizException
     */
    @PostMapping("/user/register")
    public ResultData register(UserInfoModel userModel) throws BizException {
        validatePropertes(userModel);
        String sessionOtp = (String)request.getSession().getAttribute(userModel.getPhone());
        if (!StringUtils.equals(sessionOtp,userModel.getOtp())){
            throw new BizException(ResultStateEnum.PARAMETER_ERROR,"验证码错误");
        }
        return userService.register(userModel);
    }


}
