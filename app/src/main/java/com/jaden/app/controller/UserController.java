package com.jaden.app.controller;

import com.jaden.app.beans.UserInfoExt;
import com.jaden.app.service.UserService;
import com.jaden.common.exception.BizException;
import com.jaden.common.pojo.UserInfo;
import com.jaden.common.result.ResultData;
import com.jaden.common.result.ResultStateEnum;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.SocketTimeoutException;

/**
 * Created by tangjiejin on 2018/11/21
 */
@RestController
public class UserController extends BaseController{

    @Autowired
    UserService userService;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/user/login")
    public ResultData login(UserInfoExt userInfoExt) throws Exception {
        String otp = userInfoExt.getOtp();
        String sessionOtp = (String)request.getSession().getAttribute(userInfoExt.getPhone());
        if (otp == null || userInfoExt.getName() == null || userInfoExt.getPassword() == null){
            return ResultData.retFailed(new BizException(ResultStateEnum.PARAMETER_ERROR));
        }else if (!otp.equals(sessionOtp)){
            return ResultData.retFailed(new BizException(ResultStateEnum.PARAMETER_ERROR,"验证码不正确"));
        }

        UserInfo userInfo = userService.login(userInfoExt);
        return ResultData.retSuccess(userInfo);
    }

    @GetMapping("/user/getOtp")
    public ResultData getOtp(String phone) throws Exception {
        String message = "";
        if (phone == null || phone.trim().length() <= 0){
            return ResultData.retFailed(new BizException(ResultStateEnum.PARAMETER_ERROR,"手机号不能为空"));
        }
        int otp = RandomUtils.nextInt(99999);
        otp = otp + 10000;
        request.getSession().setAttribute(phone,String.valueOf(otp));
        System.out.println("手机号：" + phone + ",验证码：" + otp);
        return ResultData.retSuccess("验证码已发送，请注意查收！");
    }


}
