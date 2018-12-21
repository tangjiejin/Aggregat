package com.jaden.common.result;

/**
 * Created by tangjiejin on 2018/12/21
 */
public enum ResultStateEnum implements ResultError{

    /**
     * 系统相关的1000开头
     */
    SYSTEM_BUSY(1000,"服务器忙，请稍后重试！"),

    UNKNOWN_ERROR(1001,"未知异常"),

    /**
     * 用户相关的2000开头
     */
    USER_NOT_LOGIN(2001,"用户未登录"),

    PARAMETER_ERROR(2002,"参数错误");

    private Integer code;

    private String message;

    ResultStateEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getErrorCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getErrorMsg() {
        return message;
    }

    @Override
    public ResultError setErrorMsg(String message) {
        this.message = message;
        return this;
    }
}
