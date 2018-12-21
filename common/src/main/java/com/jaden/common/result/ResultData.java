package com.jaden.common.result;

/**
 * Created by tangjiejin on 2018/12/21
 */
public class ResultData {

    /**
     * 请求处理状态
     * 成功status="success"
     * 失败status="failed"
     */
    String status;
    /**
     * 请求处理结果
     */
    Object data;

    public ResultData() {}

    public ResultData(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    public static ResultData retSuccess(Object data) {

        return new ResultData("success", data);
    }

    public static ResultData retFailed(ResultError error) {

        return new ResultData("failed", error);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
