package com.jaden.common.result;

/**
 * Created by tangjiejin on 2018/12/21
 */
public interface ResultError {

    Integer getErrorCode();

    String getErrorMsg();

    ResultError setErrorMsg(String message);
}
