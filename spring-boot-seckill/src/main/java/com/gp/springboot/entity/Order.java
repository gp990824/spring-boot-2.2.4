package com.gp.springboot.entity;

/**
 * @author Gp
 * @create 2020/6/3 9:43
 */

import java.util.Date;

/**
 * 秒杀成功订单
 */
public class Order {
    private Integer id;
    private Float money;
    private Long phone;
    private Date createTime;
    private Short status;
    //一个订单应包含秒杀商品信息
    private Commodity commodity;

    public Order() {
    }

    public Order(Float money, Long phone, Date createTime, Short status) {
        this.money = money;
        this.phone = phone;
        this.createTime = createTime;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}
