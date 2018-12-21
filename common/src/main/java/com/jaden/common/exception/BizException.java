package com.jaden.common.exception;

import com.jaden.common.result.ResultError;

/**
 * 包装类业务异常实现类
 * <p>
 * Created by tangjiejin on 2018/12/21
 */
public class BizException extends Exception implements ResultError {

    ResultError resultError;

    public BizException(ResultError resultError) {
        super();
        this.resultError = resultError;
    }

    public BizException(ResultError resultError, String message) {
        super();
        this.resultError = resultError;
        this.setErrorMsg(message);
    }

    @Override
    public Integer getErrorCode() {
        return resultError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return resultError.getErrorMsg();
    }

    @Override
    public ResultError setErrorMsg(String message) {
        this.resultError.setErrorMsg(message);
        return this;
    }

}
