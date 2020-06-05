package com.gp.springboot.dao;

import com.gp.springboot.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

/**
 * @author Gp
 * @create 2020/6/3 13:50
 */

/**
 * 秒杀成功的订单 DAO层
 */
@Mapper
public interface OrderDao {
    /**
     * 查询出所有的订单, 留给管理员查看
     * @return
     */
    List<Order> queryAllOrder();

    /**
     * 根据 id 查出订单
     * @param id
     * @return
     */
    Order queryOrderById(Integer id);


    /**
     * 增加订单信息,  不允许同一个用户秒杀同一件商品
     * @param order
     * @return
     * @throws DuplicateKeyException  插入相同数据, 违法唯一键约束
     */
    boolean addOrder(Order order) throws DuplicateKeyException;
}
