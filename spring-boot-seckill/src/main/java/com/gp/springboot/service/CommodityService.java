package com.gp.springboot.service;

import com.gp.springboot.entity.Commodity;
import com.gp.springboot.dto.ExposeURL;

import java.util.List;

/**
 * @author Gp
 * @create 2020/6/3 14:59
 */
public interface CommodityService {
    /**
     * 得到秒杀地址, 使用加密方式, 防止用户恶意秒杀
     * 秒杀开启时, 总是输出秒杀接口地址, 否者输出系统时间和秒杀时间
     * @param
     * @return
     */
    ExposeURL getURLWithCommodityId(Integer id);

    /**
     * 用户访问, 可以看到所有的秒杀商品
     *
     * @return
     */
    List<Commodity> queryAllCommodity();

    /**
     * 管理员访问, 根据 商品id 查出商品信息
     *
     * @param id
     * @return
     */
    Commodity queryCommodityById(Integer id);

}
