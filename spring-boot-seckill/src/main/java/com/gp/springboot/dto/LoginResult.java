package com.gp.springboot.dto;

/**
 * @author Gp
 * @create 2020/6/4 13:52
 */
public class LoginResult<T> {
    private boolean loginSuccess;
    private String message;
    private T data;

    public LoginResult(boolean loginSuccess, T data) {
        this.loginSuccess = loginSuccess;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LoginResult() {
    }

    public LoginResult(boolean loginSuccess, String message) {
        this.loginSuccess = loginSuccess;
        this.message = message;
    }

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
