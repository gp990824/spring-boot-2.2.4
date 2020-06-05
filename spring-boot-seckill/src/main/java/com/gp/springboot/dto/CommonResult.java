package com.gp.springboot.dto;

/**
 * @author Gp
 * @create 2020/6/3 14:11
 */


/**
 * 作为结果返回给 前端
 */
public class CommonResult<T> {

    private boolean success;
    private String message;
    private T data;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CommonResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public CommonResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


}
