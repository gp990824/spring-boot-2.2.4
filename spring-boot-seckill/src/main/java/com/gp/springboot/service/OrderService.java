package com.gp.springboot.service;


import com.gp.springboot.dto.CommonResult;
import com.gp.springboot.entity.Commodity;
import com.gp.springboot.entity.Order;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

/**
 * @author Gp
 * @create 2020/6/3 9:55
 */
public interface OrderService {
    /**
     * 查询出所有的订单信息
     * @return
     */
   List<Order> queryAllOrder();

    /**
     * 根据 订单号查询订单信息
     * @param id
     * @return
     */
   Order queryOrderById(Integer id);


    /**
     * 秒杀的执行结果信息
     * @param id
     * @param md5 判断秒杀URL地址是否被重写了
     */
   CommonResult<Commodity> excuteSeckill(Integer id, String md5, Long phone) throws DuplicateKeyException;
}
