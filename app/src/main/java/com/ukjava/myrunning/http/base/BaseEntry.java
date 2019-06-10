package com.ukjava.myrunning.http.base;


/**
 * @declare : 全局数据解析
 * @Author : zouyi
 * @Time : 2019/3/11
 */

public class BaseEntry<T> {
    private String resultcode;//状态码
    private int error_code;//错误信息
    private T result;//根据泛型解析数据返回，
    private String reason;//查询结果

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    public boolean isSuccess(){
        return getStatus().equals("200");
    }

    public String getStatus() {
        return resultcode;
    }

    public void setStatus(String status) {
        this.resultcode = status;
    }

    public int getErrorinfo() {
        return error_code;
    }

    public void setErrorinfo(int errorinfo) {
        this.error_code = errorinfo;
    }

    public T getData() {
        return result;
    }

    public void setData(T data) {
        this.result = data;
    }
}
