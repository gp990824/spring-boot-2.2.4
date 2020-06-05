package com.gp.springboot.entity;

/**
 * @author Gp
 * @create 2020/6/3 9:37
 */


import java.util.Date;

/**
 * 秒杀商品
 */
public class Commodity {
    //商品ID
    private Integer id;
    //商品信息
    private String title;
    //原始价格
    private Float price;
    //秒杀价格
    private Float costPrice;
    //库存数量
    private Integer stockCount;
    //商品秒杀开始时间
    private Date startTime;
    //商品秒杀结束时间
    private Date endTime;

    private String img;

    public Commodity() {
    }

    public Commodity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Float costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
