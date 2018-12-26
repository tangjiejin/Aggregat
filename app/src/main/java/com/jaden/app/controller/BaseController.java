package com.jaden.app.controller;

import com.jaden.app.validator.ValidationResult;
import com.jaden.app.validator.ValidatorImpl;
import com.jaden.common.exception.BizException;
import com.jaden.common.result.ResultData;
import com.jaden.common.result.ResultStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangjiejin on 2018/12/21
 */
@RestController
public class BaseController {

    @Autowired
    ValidatorImpl validator;

    /**
     * 统一异常处理器
     *
     * @param e
     * @return
     */
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

    /**
     * 统一参数校验器
     *
     * @param bean
     * @throws BizException
     */
    public void validatePropertes(Object bean) throws BizException {
        ValidationResult validate = validator.validate(bean);
        if (validate.isHasError()){
            throw new BizException(ResultStateEnum.PARAMETER_ERROR,validate.getErrorMsg());
        }
    }
}















