package com.gp.springboot.dto;

import com.gp.springboot.entity.Commodity;

import java.util.Date;

/**
 * @author Gp
 * @create 2020/6/3 14:38
 */
public class ExposeURL {

    private Date currentTime;
    private boolean success;
    //加密字符, 用于地址验证
    private String md5;

    private String message;

    private Commodity commodity;

    public Commodity getCommodity() {
        return commodity;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
