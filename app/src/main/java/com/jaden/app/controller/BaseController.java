package com.jaden.app.controller;

import com.jaden.common.exception.BizException;
import com.jaden.common.result.ResultData;
import com.jaden.common.result.ResultStateEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangjiejin on 2018/12/21
 */
@RestController
public class BaseController {

    @ExceptionHandler
    public ResultData exceptionHandler(Exception e){
        ResultData resultData = new ResultData();
        resultData.setStatus("failed");
        if (e instanceof BizException){
            BizException be = (BizException)e;
            resultData.setData(be);
        }else {
            e.printStackTrace();
            resultData.setData(new BizException(ResultStateEnum.UNKNOWN_ERROR));
        }
        return resultData;
    }
}
